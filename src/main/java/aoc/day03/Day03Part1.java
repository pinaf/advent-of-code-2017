package aoc.day03;

import aoc.Challenge;

public final class Day03Part1 implements Challenge<Long> {

    private final Challenge<Long> wrapped;

    public Day03Part1(final long target) {
        this.wrapped = new Day03(
            new ValueFunction.Increment(),
            state -> state.value() >= target,
            new ValueFunction.ManhattanDistanceToOrigin()
        );
    }

    @Override
    public Long run() {
        return this.wrapped.run();
    }

}
