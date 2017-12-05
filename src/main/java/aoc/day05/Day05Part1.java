package aoc.day05;

import aoc.ChallengeWrap;

public final class Day05Part1 extends ChallengeWrap<Long> {

    private static final Operation OPERATION = new Operation.Increment();

    public Day05Part1() {
        super(new Day05(Day05Part1.OPERATION));
    }

    public Day05Part1(final CharSequence input) {
        super(new Day05(Day05Part1.OPERATION, input));
    }

    public Day05Part1(final int[] jumps) {
        super(new Day05(Day05Part1.OPERATION, jumps));
    }

}
