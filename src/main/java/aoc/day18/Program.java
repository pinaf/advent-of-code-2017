package aoc.day18;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

public interface Program {

    boolean runNextInstruction();

    boolean runTilBlocked();

    long sent();

    boolean halted();

    boolean blocked();

    @Slf4j
    @Accessors(fluent = true)
    final class Default implements Program {

        private final State state = new State.Default();

        private final List<String> instructions;

        private final long pid;

        private final BlockingQueue<Long> read;

        private final Queue<Long> write;

        private int pc;

        @Getter
        private long sent;

        private long rcvd;

        private boolean block;

        public Default(final List<String> instructions, final long pid,
            final BlockingQueue<Long> read, final Queue<Long> write) {
            this.instructions = instructions;
            this.pid = pid;
            this.read = read;
            this.write = write;
            this.state.setRegister("p", pid);
        }

        @Override
        public boolean blocked() {
            return this.block;
        }

        @Override
        public boolean runTilBlocked() {
            while (!this.halted() && !this.blocked()) {
                this.runNextInstruction();
            }
            return this.halted();
        }

        @Override
        public boolean runNextInstruction() {
            if (this.halted()) {
                return true;
            }
            final String instruction = this.instructions.get(this.pc);
            final String[] split = instruction.split(" ");
            final String instr = split[0];
            final String target = split[1];
            //Program.Default.log.info("PID = {}, PC = {}, INSTR = {}", this.pid, this.pc, instruction);
            final long value;
            switch (instr) {
                case "snd":
                    this.write.add(this.parseValue(split[1]));
                    this.sent++;
                    //log.info("PID = {}, Sent = {}", this.pid, this.sent);
                    break;
                case "set":
                    this.state.setRegister(target, this.parseValue(split[2]));
                    break;
                case "add":
                    this.state.setRegister(target, this.state.readRegister(target) + this.parseValue(split[2]));
                    break;
                case "mul":
                    this.state.setRegister(target, this.state.readRegister(target) * this.parseValue(split[2]));
                    break;
                case "mod":
                    value = this.parseValue(split[2]);
                    this.state.setRegister(target, this.state.readRegister(target) % value);
                    break;
                case "rcv":
                    this.block = true;
                    if (this.read.isEmpty()) {
                        return false;
                    }
                    try {
                        //Program.Default.log.info("PID = {} blocked", this.pid);
                        this.state.setRegister(target, this.read.take());
                        this.block = false;
                        this.rcvd++;
                        //Program.Default.log.info("PID = {} unblocked; Rcvd = {}", this.pid, this.rcvd);
                    } catch (final InterruptedException ex) {
                        throw new IllegalStateException(ex);
                    }
                    break;
                case "jgz":
                    value = this.parseValue(split[1]);
                    if (value > 0L) {
                        this.pc += (int) this.parseValue(split[2]);
                        //log.info("PC = {}", this.pc);
                        return false;
                    }
            }
            this.pc++;
            return this.halted();
        }

        @Override
        public boolean halted() {
            return this.pc < 0 || this.pc > this.instructions.size();
        }

        private long parseValue(final String value) {
            final char first = value.charAt(0);
            if (first >= '0' && first <= '9' || first == '-') {
                return Long.parseLong(value);
            } else {
                return this.state.readRegister(value);
            }
        }

    }

}
