package aoc.day05;

import aoc.Challenge;

public final class Day05Part1 implements Challenge<Long> {

    private static final Operation OPERATION = new Operation.Increment();

    private final Challenge<Long> wrapped;

    public Day05Part1(final CharSequence input) {
        this.wrapped = new Day05(Day05Part1.OPERATION, input);
    }

    public Day05Part1(final int[] jumps) {
        this.wrapped = new Day05(Day05Part1.OPERATION, jumps);
    }

    @Override
    public Long run() {
        return this.wrapped.run();
    }

}
