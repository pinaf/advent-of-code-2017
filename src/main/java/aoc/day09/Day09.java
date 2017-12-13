package aoc.day09;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day09 implements TwoPartChallenge<Long, Long> {

    private final String input;

    public Day09() {
        this(new StdInput(9).read());
    }

    @Override
    public Long part1() {
        return new Day09Common(new Solution.TotalGroupScore(), this.input).run();
    }

    @Override
    public Long part2() {
        return new Day09Common(new Solution.TotalGarbageSeen(), this.input).run();
    }

}
