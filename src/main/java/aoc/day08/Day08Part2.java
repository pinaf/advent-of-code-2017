package aoc.day08;

import aoc.ChallengeWrap;

public final class Day08Part2 extends ChallengeWrap<Long> {

    private static final Solution SOLUTION = new Solution.HighestAllTimeRegister();

    public Day08Part2() {
        super(new Day08(Day08Part2.SOLUTION));
    }

    public Day08Part2(final String input) {
        super(new Day08(Day08Part2.SOLUTION, input));
    }

}
