package aoc.day11;

import aoc.ChallengeWrap;

public final class Day11Part1 extends ChallengeWrap<Integer> {

    private static final Solution SOLUTION = new Solution.FinalDistance();

    public Day11Part1() {
        super(new Day11(Day11Part1.SOLUTION));
    }

    public Day11Part1(final String input) {
        super(new Day11(Day11Part1.SOLUTION, input));
    }

}
