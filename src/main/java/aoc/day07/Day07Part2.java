package aoc.day07;

import aoc.ChallengeWrap;

public final class Day07Part2 extends ChallengeWrap<Long> {

    private static final SolutionFunction<Long> SOLUTION = new SolutionFunction.FindImbalance();

    public Day07Part2() {
        super(new Day07<>(Day07Part2.SOLUTION));
    }

    public Day07Part2(final String input) {
        super(new Day07<>(Day07Part2.SOLUTION, input));
    }

}
