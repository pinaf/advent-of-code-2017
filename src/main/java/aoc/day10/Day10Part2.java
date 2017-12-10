package aoc.day10;

import aoc.ChallengeWrap;
import aoc.StdInput;

public final class Day10Part2 extends ChallengeWrap<String> {

    private static final int ROUNDS = 64;

    private static final int[] TAIL = {17, 31, 73, 47, 23};

    private static final Solution<String> SOLUTION = new Solution.DenseHash();

    private static final InputTransform TRANSFORM = new InputTransform.AppendTail(Day10Part2.TAIL);

    public Day10Part2() {
        this(new StdInput(10).read());
    }

    public Day10Part2(final CharSequence input) {
        super(new Day10<>(Day10Part2.SOLUTION, Day10Part2.TRANSFORM, 256, input.chars().toArray(), Day10Part2.ROUNDS));
    }

}
