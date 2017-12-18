package aoc.day18;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public final class Day18 implements TwoPartChallenge<Long, Long> {

    private final State state = new State.Default();

    private final List<String> instructions;

    public Day18() {
        this(new StdInput(18).read());
    }

    public Day18(final String input) {
        this(
            Arrays.stream(input.split("\n"))
                .collect(Collectors.toList())
                //.mapToInt(Integer::parseInt)
                //.toArray()
        );
    }

    @Override
    public Long part1() {
        final int length = this.instructions.size();
        long sound = 0L;
        int pc = 0;
        while (pc >= 0 && pc < length) {
            final String instruction = this.instructions.get(pc);
            final String[] split = instruction.split(" ");
            final String instr = split[0];
            final String target = split[1];
            //log.info("PC = {}, INSTR = {}", pc, instruction);
            long value;
            switch (instr) {
                case "snd":
                    sound = this.parseValue(split[1]);
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
                    this.state.setRegister(target, this.state.readRegister(target) % this.parseValue(split[2]));
                    break;
                case "rcv":
                    value = this.parseValue(split[1]);
                    if (value != 0L) {
                        return sound;
                    }
                    break;
                case "jgz":
                    value = this.parseValue(split[1]);
                    if (value > 0L) {
                        pc += this.parseValue(split[2]);
                        continue;
                    }
            }
            pc++;
        }
        return sound;
    }

    @Override
    public Long part2() {
        final BlockingQueue<Long> queue0 = new ArrayBlockingQueue<>(1000);
        final BlockingQueue<Long> queue1 = new ArrayBlockingQueue<>(1000);
        final Program prog0 = new Program.Default(this.instructions, 0L, queue0, queue1);
        final Program prog1 = new Program.Default(this.instructions, 1L, queue1, queue0);
        boolean halt = false;
        boolean halt0 = false;
        boolean halt1 = false;
        while (!halt) {
            if (!halt0) {
                halt0 = prog0.runNextInstruction();
            }
            if (!halt1) {
                halt1 = prog1.runNextInstruction();
            }
            if (halt0 && halt1) {
                halt = true;
            }
            if (prog0.blocked() && prog1.blocked()) {
                log.info("Deadlock detected!");
                halt = true;
            }
        }
        return prog1.sent();
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
