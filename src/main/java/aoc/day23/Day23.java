package aoc.day23;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public final class Day23 implements TwoPartChallenge<Long, Long> {

    private final String input;

    public Day23() {
        this(new StdInput(23).read());
    }

    @Override
    public Long part1() {
        final Instruction.InstrCounting mul = new Instruction.InstrCounting(new InstrMul());
        new Program.Default(
            new InstructionMap.Mutable(new Standard())
                .with("mul", mul),
            this.input
        ).run();
        return mul.count();
    }

    @Override
    public Long part2() {
        return Day23.countComposites(109300, 126300, 17);
    }

    private static long countComposites(final int start, final int end, final int step) {
        long count = 0L;
        for (int current = start; current <= end; current += step) {
            for (int divisor = 2; divisor < current; ++divisor) {
                if (current % divisor == 0) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

}
