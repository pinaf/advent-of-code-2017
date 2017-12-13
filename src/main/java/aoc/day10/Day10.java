package aoc.day10;

import java.util.Arrays;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day10 implements TwoPartChallenge<Long, String> {

    private static final int[] TAIL = {17, 31, 73, 47, 23};

    private final int length;

    private final String input;

    public Day10() {
        this(new StdInput(10).read());
    }

    public Day10(final String input) {
        this(256, input);
    }

    @Override
    public Long part1() {
        return new Day10Common<>(
            new Solution.ProductOfFirstTwo(),
            new InputTransform.Identity(),
            this.length,
            Arrays.stream(this.input.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray(),
            1
        ).run();
    }

    @Override
    public String part2() {
        return new Day10Common<>(
            new Solution.DenseHash(),
            new InputTransform.AppendTail(Day10.TAIL),
            this.length,
            this.input.chars().toArray(),
            64
        ).run();
    }

}
