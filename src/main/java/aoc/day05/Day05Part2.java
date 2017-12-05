package aoc.day05;

import aoc.ChallengeWrap;

public final class Day05Part2 extends ChallengeWrap<Long> {

    private static final Operation OPERATION = new Operation.Conditional();

    public Day05Part2() {
        super(new Day05(Day05Part2.OPERATION));
    }

    public Day05Part2(final CharSequence input) {
        super(new Day05(Day05Part2.OPERATION, input));
    }

    public Day05Part2(final int[] jumps) {
        super(new Day05(Day05Part2.OPERATION, jumps));
    }

}
