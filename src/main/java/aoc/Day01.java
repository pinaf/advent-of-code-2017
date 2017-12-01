package aoc;

import java.util.Arrays;
import java.util.regex.Pattern;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day01 implements Challenge<Long> {

    private static final Pattern PATTERN = Pattern.compile("(?!^)");

    private final int[] input;

    public Day01(final String input) {
        this(
            Arrays
                .stream(Day01.PATTERN.split(input))
                .mapToInt(Integer::parseUnsignedInt)
                .toArray()
        );
    }

    @Override
    public Long run() {
        if (this.input.length < 2) {
            return 0L;
        }
        int last = this.input[0];
        long sum = 0L;
        for (int idx = 1; idx < this.input.length; ++idx) {
            final int current = this.input[idx];
            if (current == last) {
                sum += (long) last;
            }
            last = current;
        }
        if (this.input[0] == this.input[this.input.length - 1]) {
            sum += this.input[0];
        }
        return sum;
    }

}
