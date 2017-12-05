package aoc.day02;

import aoc.ChallengeWrap;

public final class Day02Part1 extends ChallengeWrap<Long> {

    private static final Strategy STRATEGY = new Strategy.MinMax();

    public Day02Part1() {
        super(new Day02(Day02Part1.STRATEGY));
    }

    public Day02Part1(final String input) {
        super(new Day02(Day02Part1.STRATEGY, input));
    }

}
