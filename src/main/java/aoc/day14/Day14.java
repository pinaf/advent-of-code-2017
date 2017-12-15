package aoc.day14;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day14 implements TwoPartChallenge<Long, Long> {

    private final String input;

    public Day14() {
        this(new StdInput(14).read());
    }

    @Override
    public Long part1() {
        return (long) new UsageHashGrid(this.input).all().sum();
    }

    @Override
    public Long part2() {
        return (long) new UsageRegionGrid(new UsageHashGrid(this.input)).all().max().getAsInt();
    }


}
