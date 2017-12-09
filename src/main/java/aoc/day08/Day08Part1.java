package aoc.day08;

import aoc.ChallengeWrap;

public final class Day08Part1 extends ChallengeWrap<Long> {

    private static final Solution SOLUTION = new Solution.HighestFinalRegister();

    public Day08Part1() {
        super(new Day08(Day08Part1.SOLUTION));
    }

    public Day08Part1(final String input) {
        super(new Day08(Day08Part1.SOLUTION, input));
    }

}
