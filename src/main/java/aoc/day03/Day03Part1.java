package aoc.day03;

import aoc.ChallengeWrap;
import aoc.StdInput;

public final class Day03Part1 extends ChallengeWrap<Long> {

    public Day03Part1() {
        this(Long.parseLong(new StdInput(3).read().trim()));
    }

    public Day03Part1(final long target) {
        super(
            new Day03(
                new ValueFunction.Increment(),
                state -> state.value() >= target,
                new ValueFunction.ManhattanDistanceToOrigin()
            )
        );
    }

}
