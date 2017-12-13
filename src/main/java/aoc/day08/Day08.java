package aoc.day08;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day08 implements TwoPartChallenge<Long, Long> {

    private final String input;

    public Day08() {
        this(new StdInput(8).read());
    }

    @Override
    public Long part1() {
        return new Day08Common(new Solution.HighestFinalRegister(), this.input).run();
    }

    @Override
    public Long part2() {
        return new Day08Common(new Solution.HighestAllTimeRegister(), this.input).run();
    }

}
