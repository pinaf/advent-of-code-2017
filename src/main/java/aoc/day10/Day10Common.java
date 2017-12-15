package aoc.day10;

import aoc.Challenge;

public final class Day10Common<T> implements Challenge<T> {

    private final Solution<T> solution;

    private final int[] lengths;

    private final KnotHash hash;

    Day10Common(final Solution<T> solution, final KnotHash hash, final int[] lengths) {
        this.solution = solution;
        this.lengths = lengths;
        this.hash = hash;
    }

    @Override
    public T run() {
        return this.solution.apply(this.hash.hash(this.lengths));
    }

}
