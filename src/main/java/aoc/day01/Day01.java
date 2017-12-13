package aoc.day01;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day01 implements TwoPartChallenge<Long, Long> {

    private final String input;

    public Day01() {
        this(new StdInput(1).read());
    }

    @Override
    public Long part1() {
        return new Day01Common(this.input, new NeighborStrategy.Next()).run();
    }

    @Override
    public Long part2() {
        return new Day01Common(this.input, new NeighborStrategy.HalfAround()).run();
    }

}
