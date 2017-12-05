package aoc.day02;

import aoc.ChallengeWrap;

public final class Day02Part2 extends ChallengeWrap<Long> {

    private static final Strategy STRATEGY = new Strategy.EvenlyDivisible();

    public Day02Part2() {
        super(new Day02(Day02Part2.STRATEGY));
    }

    public Day02Part2(final String input) {
        super(new Day02(Day02Part2.STRATEGY, input));
    }

}
