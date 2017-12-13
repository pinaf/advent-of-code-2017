package aoc.day12;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day12 implements TwoPartChallenge<Long, Long> {

    private final String input;

    public Day12() {
        this(new StdInput(12).read());
    }

    @Override
    public Long part1() {
        return new Day12Common(new Solution.GroupSize(0L), this.input).run();
    }

    @Override
    public Long part2() {
        return new Day12Common(new Solution.NumberOfGroups(), this.input).run();
    }

}
