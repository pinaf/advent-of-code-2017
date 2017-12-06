package aoc.day06;

import aoc.ChallengeWrap;

public final class Day06Part1 extends ChallengeWrap<Long> {

    private static final ResultFunction RESULT = new ResultFunction.TotalSteps();

    public Day06Part1() {
        super(new Day06(Day06Part1.RESULT));
    }

    public Day06Part1(final int head, final int... tail) {
        super(new Day06(Day06Part1.RESULT, head, tail));
    }

}
