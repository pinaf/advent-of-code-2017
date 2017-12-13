package aoc.day11;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day11 implements TwoPartChallenge<Integer, Integer> {

    private final String input;

    public Day11() {
        this(new StdInput(11).read());
    }

    @Override
    public Integer part1() {
        return new Day11Common(new Solution.FinalDistance(), this.input).run();
    }

    @Override
    public Integer part2() {
        return new Day11Common(new Solution.GreatestDistance(), this.input).run();
    }

}
