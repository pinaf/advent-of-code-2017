package aoc.day11;

import aoc.ChallengeWrap;

public final class Day11Part2 extends ChallengeWrap<Integer> {

    private static final Solution SOLUTION = new Solution.GreatestDistance();

    public Day11Part2() {
        super(new Day11(Day11Part2.SOLUTION));
    }

    public Day11Part2(final String input) {
        super(new Day11(Day11Part2.SOLUTION, input));
    }

}
