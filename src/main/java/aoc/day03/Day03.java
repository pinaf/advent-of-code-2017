package aoc.day03;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day03 implements TwoPartChallenge<Long, Long> {

    private final long target;

    public Day03() {
        this(new StdInput(3).read());
    }

    public Day03(final String input) {
        this(Long.parseLong(input.trim()));
    }

    @Override
    public Long part1() {
        return new Day03Common(
            new ValueFunction.Increment(),
            state -> state.value() >= this.target,
            new ValueFunction.ManhattanDistanceToOrigin()
        ).run();
    }

    @Override
    public Long part2() {
        return new Day03Common(
            new ValueFunction.SumOfNeighbors(),
            state -> state.value() > this.target,
            new ValueFunction.StateValue()
        ).run();
    }

}
