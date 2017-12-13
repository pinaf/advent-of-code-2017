package aoc.day06;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day06 implements TwoPartChallenge<Long, Long> {

    private static final Pattern PATTERN = Pattern.compile("(\\s)+");

    private final int[] input;

    public Day06() {
        this(new StdInput(6).read());
    }

    public Day06(final int head, final int... tail) {
        this(
            IntStream.concat(
                IntStream.of(head),
                Arrays.stream(tail)
            ).toArray()
        );
    }

    public Day06(final String input) {
        this(
            Arrays.stream(Day06.PATTERN.split(input))
                .mapToInt(Integer::parseUnsignedInt)
                .toArray()
        );
    }

    @Override
    public Long part1() {
        return new Day06Common(new ResultFunction.TotalSteps(), this.input).run();
    }

    @Override
    public Long part2() {
        return new Day06Common(new ResultFunction.CycleSize(), this.input).run();
    }

}
