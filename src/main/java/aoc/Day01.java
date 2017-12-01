package aoc;

import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Pattern;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day01 implements Challenge<Long> {

    private static final Pattern PATTERN = Pattern.compile("(?!^)");

    private final int[] input;

    private final Function<Integer, Integer> neighbor;

    public Day01(final String input, final Day01.NeighborStrategy strategy) {
        this(
            Arrays
                .stream(Day01.PATTERN.split(input))
                .mapToInt(Integer::parseUnsignedInt)
                .toArray(),
            strategy
        );
    }

    public Day01(final int[] input, final Day01.NeighborStrategy strategy) {
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

    public interface NeighborStrategy extends Function<Integer, Function<Integer, Integer>> {

        final class Next implements Day01.NeighborStrategy {
            @Override
            public Function<Integer, Integer> apply(final Integer length) {
                return n -> (n + 1) % length;
            }
        }

    }

}
