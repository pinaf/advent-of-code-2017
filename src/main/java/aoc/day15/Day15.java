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
        return this.count(
            new Generator.Simple(this.seedA, 16807L, 2147483647L),
            new Generator.Simple(this.seedB, 48271L, 2147483647L),
            40000000L
        );
    }

    @Override
    public Long part2() {
        return this.count(
            new Generator.Selective(new Generator.Simple(this.seedA, 16807L, 2147483647L), 4L),
            new Generator.Selective(new Generator.Simple(this.seedB, 48271L, 2147483647L), 8L),
            5000000L
        );
    }

    private long count(final Generator genA, final Generator genB, final long iterations) {
        final Judge judge = new Judge.Lower16Bits();
        for (long idx = 0L; idx < iterations; ++idx) {
            judge.compare(genA, genB);
        }
        return judge.count();
    }

}
