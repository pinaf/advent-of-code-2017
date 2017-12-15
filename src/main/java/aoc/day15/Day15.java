package aoc.day15;

import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day15 implements TwoPartChallenge<Long, Long> {

    private final long seedA;

    private final long seedB;

    public Day15() {
        this(722L, 354L);
    }

    @Override
    public Long part1() {
        long judge = 0L;
        long valueA = seedA;
        long valueB = seedB;
        for (long idx = 0L; idx < 40000000L; ++idx) {
            valueA = (valueA * 16807L) % 2147483647L;
            valueB = (valueB * 48271L) % 2147483647L;
            if ((valueA & 0xffff) == (valueB & 0xffff)) {
                judge++;
            }
        }
        return judge;
    }

    @Override
    public Long part2() {
        long judge = 0L;
        long valueA = seedA;
        long valueB = seedB;
        for (long idx = 0L; idx < 5000000L; ++idx) {
            valueA = (valueA * 16807L) % 2147483647L;
            while (valueA % 4L != 0L) {
                valueA = (valueA * 16807L) % 2147483647L;
            }
            valueB = (valueB * 48271L) % 2147483647L;
            while (valueB % 8L != 0L) {
                valueB = (valueB * 48271L) % 2147483647L;
            }
            if ((valueA & 0xffff) == (valueB & 0xffff)) {
                judge++;
            }
        }
        return judge;
    }

}
