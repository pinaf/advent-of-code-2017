package aoc.day10;

import java.util.Arrays;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day10 implements TwoPartChallenge<Long, String> {

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
            new KnotHash.Simple(this.length),
            Arrays.stream(this.input.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray()
        ).run();
    }

    @Override
    public String part2() {
        return new Day10Common<>(
            new Solution.HashHex(),
            new KnotHash.Dense(this.length, 64),
            this.input.chars().toArray()
        ).run();
    }

}
