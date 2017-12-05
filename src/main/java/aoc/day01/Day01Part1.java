package aoc.day01;

import aoc.ChallengeWrap;

public final class Day01Part1 extends ChallengeWrap<Long> {

    private static final NeighborStrategy STRATEGY = new NeighborStrategy.Next();

    public Day01Part1() {
        super(new Day01(Day01Part1.STRATEGY));
    }

    public Day01Part1(final String input) {
        super(new Day01(input, Day01Part1.STRATEGY));
    }

}
