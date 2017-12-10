package aoc.day10;

import aoc.ChallengeWrap;

public final class Day10Part1 extends ChallengeWrap<Long> {

    private static final int ROUNDS = 1;

    private static final Solution<Long> SOLUTION = new Solution.ProductOfFirstTwo();

    private static final InputTransform TRANSFORM = new InputTransform.Identity();

    public Day10Part1() {
        super(new Day10<>(Day10Part1.SOLUTION, Day10Part1.TRANSFORM, Day10Part1.ROUNDS));
    }

    public Day10Part1(final int length, final int[] lengths) {
        super(new Day10<>(Day10Part1.SOLUTION, Day10Part1.TRANSFORM, length, lengths, Day10Part1.ROUNDS));
    }

}
