package aoc.day12;

import aoc.ChallengeWrap;

public final class Day12Part1 extends ChallengeWrap<Long> {

    private static final Solution SOLUTION = new Solution.GroupSize(0L);

    public Day12Part1() {
        super(new Day12(Day12Part1.SOLUTION));
    }

    public Day12Part1(final String input) {
        super(new Day12(Day12Part1.SOLUTION, input));
    }

}
