package aoc.day06;

import aoc.ChallengeWrap;

public final class Day06Part2 extends ChallengeWrap<Long> {

    private static final ResultFunction RESULT = new ResultFunction.CycleSize();

    public Day06Part2() {
        super(new Day06(Day06Part2.RESULT));
    }

    public Day06Part2(final int head, final int... tail) {
        super(new Day06(Day06Part2.RESULT, head, tail));
    }

}
