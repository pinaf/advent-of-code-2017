package aoc.day05;

import aoc.Challenge;

public final class Day05Part2 implements Challenge<Long> {

    private static final Operation OPERATION = new Operation.Conditional();

    private final Challenge<Long> wrapped;

    public Day05Part2(final CharSequence input) {
        this.wrapped = new Day05(Day05Part2.OPERATION, input);
    }

    public Day05Part2(final int[] jumps) {
        this.wrapped = new Day05(Day05Part2.OPERATION, jumps);
    }

    @Override
    public Long run() {
        return this.wrapped.run();
    }

}
