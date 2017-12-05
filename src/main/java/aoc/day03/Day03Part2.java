package aoc.day03;

import aoc.ChallengeWrap;
import aoc.StdInput;

public final class Day03Part2 extends ChallengeWrap<Long> {

    public Day03Part2() {
        this(Long.parseLong(new StdInput(3).read().trim()));
    }

    public Day03Part2(final long target) {
        super(
            new Day03(
                new ValueFunction.SumOfNeighbors(),
                state -> state.value() > target,
                new ValueFunction.StateValue()
            )
        );
    }

}
