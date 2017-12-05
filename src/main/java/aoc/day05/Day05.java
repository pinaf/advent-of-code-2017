package aoc.day05;

import java.util.Arrays;
import java.util.regex.Pattern;

import aoc.Challenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day05 implements Challenge<Long> {

    private static final Pattern PATTERN = Pattern.compile("(\\s)+");

    private final Operation operation;

    private final int[] jumps;

    public Day05(final Operation operation, final CharSequence input) {
        this(
            operation,
            Arrays.stream(Day05.PATTERN.split(input))
                .mapToInt(Integer::parseInt)
                .toArray()
        );
    }

    @Override
    public Long run() {
        long steps = 0L;
        int offset = 0;
        while (offset >= 0 && offset < this.jumps.length) {
            final int jump = this.jumps[offset];
            this.jumps[offset] = this.operation.apply(jump);
            offset += jump;
            steps++;
        }
        return steps;
    }

}
