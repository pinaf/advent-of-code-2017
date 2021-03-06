package aoc.day01;

import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Pattern;

import aoc.Challenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day01Common implements Challenge<Long> {

    private static final Pattern PATTERN = Pattern.compile("(?!^)");

    private final int[] input;

    private final Function<Integer, Integer> neighbor;

    Day01Common(final String input, final NeighborStrategy strategy) {
        this(
            Arrays
                .stream(Day01Common.PATTERN.split(input.trim()))
                .mapToInt(Integer::parseUnsignedInt)
                .toArray(),
            strategy
        );
    }

    Day01Common(final int[] input, final NeighborStrategy strategy) {
        this(input, strategy.apply(input.length));
    }

    @Override
    public Long run() {
        if (this.input.length < 2) {
            return 0L;
        }
        long sum = 0L;
        for (int idx = 0; idx < this.input.length; ++idx) {
            final int current = this.input[idx];
            if (current == this.input[this.neighbor.apply(idx)]) {
                sum += (long) current;
            }
        }
        return sum;
    }

}
