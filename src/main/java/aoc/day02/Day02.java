package aoc.day02;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day02 implements TwoPartChallenge<Long, Long> {

    private final String input;

    public Day02() {
        this(new StdInput(2).read());
    }

    @Override
    public Long part1() {
        return new Day02Common(new Strategy.MinMax(), this.input).run();
    }

    @Override
    public Long part2() {
        return new Day02Common(new Strategy.EvenlyDivisible(), this.input).run();
    }

}
