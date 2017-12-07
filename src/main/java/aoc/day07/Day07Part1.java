package aoc.day07;

import aoc.ChallengeWrap;

public final class Day07Part1 extends ChallengeWrap<String> {

    private static final SolutionFunction<String> SOLUTION = new SolutionFunction.GrabName();

    public Day07Part1() {
        super(new Day07<>(Day07Part1.SOLUTION));
    }

    public Day07Part1(final String input) {
        super(new Day07<>(Day07Part1.SOLUTION, input));
    }

}
