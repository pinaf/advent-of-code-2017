package aoc.day09;

import aoc.ChallengeWrap;

public final class Day09Part1 extends ChallengeWrap<Long> {

    private static final Solution SOLUTION = new Solution.TotalGroupScore();

    public Day09Part1() {
        super(new Day09(Day09Part1.SOLUTION));
    }

    public Day09Part1(final String input) {
        super(new Day09(Day09Part1.SOLUTION, input));
    }

}
