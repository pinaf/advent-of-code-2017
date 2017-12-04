package aoc.day03;

import aoc.Challenge;

public final class Day03Part2 implements Challenge<Long> {

    private final Challenge<Long> wrapped;

    public Day03Part2(final long target) {
        this.wrapped = new Day03(
            new ValueFunction.SumOfNeighbors(),
            state -> state.value() > target,
            new ValueFunction.StateValue()
        );
    }

    @Override
    public Long run() {
        return this.wrapped.run();
    }

}
