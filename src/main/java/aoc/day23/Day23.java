package aoc.day23;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public final class Day23 implements TwoPartChallenge<Long, Long> {

    private final State state = new State.Default();

    private final List<String> instructions;

    public Day23() {
        this(new StdInput(23).read());
    }

    public Day23(final String input) {
        this(
            Arrays.stream(input.split("\n"))
                .collect(Collectors.toList())
        );
    }

    @Override
    public Long part1() {
        final int length = this.instructions.size();
        long count = 0L;
        int pc = 0;
        while (pc >= 0 && pc < length) {
            final String instruction = this.instructions.get(pc);
            final String[] split = instruction.split(" ");
            final String instr = split[0];
            final String target = split[1];
            //log.info("PC = {}, INSTR = {}", pc, instruction);
            long value;
            switch (instr) {
                case "set":
                    this.state.setRegister(target, this.parseValue(split[2]));
                    break;
                case "sub":
                    this.state.setRegister(target, this.state.readRegister(target) - this.parseValue(split[2]));
                    break;
                case "mul":
                    this.state.setRegister(target, this.state.readRegister(target) * this.parseValue(split[2]));
                    count++;
                    break;
                case "jnz":
                    value = this.parseValue(split[1]);
                    if (value != 0L) {
                        pc += this.parseValue(split[2]);
                        continue;
                    }
            }
            pc++;
        }
        return count;
    }

    @Override
    public Long part2() {
        final int length = this.instructions.size();
        int pc = 0;
        this.state.setRegister("a", 1L);
        while (pc >= 0 && pc < length) {
            final String instruction = this.instructions.get(pc);
            final String[] split = instruction.split(" ");
            final String instr = split[0];
            final String target = split[1];
            if (pc == 28) {
                log.info("PC = {}, INSTR = {}", pc, instruction);
                log.info(this.state.toString());
            }
            long value;
            switch (instr) {
                case "set":
                    this.state.setRegister(target, this.parseValue(split[2]));
                    break;
                case "sub":
                    this.state.setRegister(target, this.state.readRegister(target) - this.parseValue(split[2]));
                    break;
                case "mul":
                    this.state.setRegister(target, this.state.readRegister(target) * this.parseValue(split[2]));
                    break;
                case "jnz":
                    value = this.parseValue(split[1]);
                    if (value != 0L) {
                        pc += this.parseValue(split[2]);
                        continue;
                    }
            }
            pc++;
        }
        return this.state.readRegister("h");
    }

    private long countPrimes() {
        long h = 0L;
        for (int b = 109300; b <= 126300; b += 17) {
            for (int n = 2; n < b; ++n) {
                if (b % n == 0) {
                    h++;
                    break;
                }
            }
        }
        return h;
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
