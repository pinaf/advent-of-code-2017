package aoc.day09;

import aoc.ChallengeWrap;

public final class Day09Part2 extends ChallengeWrap<Long> {

    private static final Solution SOLUTION = new Solution.TotalGarbageSeen();

    public Day09Part2() {
        super(new Day09(Day09Part2.SOLUTION));
    }

    public Day09Part2(final String input) {
        super(new Day09(Day09Part2.SOLUTION, input));
    }

}
