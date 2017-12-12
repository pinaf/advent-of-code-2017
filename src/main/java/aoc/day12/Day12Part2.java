package aoc.day12;

import aoc.ChallengeWrap;

public final class Day12Part2 extends ChallengeWrap<Long> {

    private static final Solution SOLUTION = new Solution.NumberOfGroups();

    public Day12Part2() {
        super(new Day12(Day12Part2.SOLUTION));
    }

    public Day12Part2(final String input) {
        super(new Day12(Day12Part2.SOLUTION, input));
    }

}
