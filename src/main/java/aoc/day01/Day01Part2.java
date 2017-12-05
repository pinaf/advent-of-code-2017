package aoc.day01;

import aoc.ChallengeWrap;

public final class Day01Part2 extends ChallengeWrap<Long> {

    private static final NeighborStrategy STRATEGY = new NeighborStrategy.HalfAround();

    public Day01Part2() {
        super(new Day01(Day01Part2.STRATEGY));
    }

    public Day01Part2(final String input) {
        super(new Day01(input, Day01Part2.STRATEGY));
    }

}
