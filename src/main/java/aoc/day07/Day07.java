package aoc.day07;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day07 implements TwoPartChallenge<String, Long> {

    private final String input;

    public Day07() {
        this(new StdInput(7).read());
    }

    @Override
    public String part1() {
        return new Day07Common<>(new SolutionFunction.GrabName(), this.input).run();
    }

    @Override
    public Long part2() {
        return new Day07Common<>(new SolutionFunction.FindImbalance(), this.input).run();
    }

}
