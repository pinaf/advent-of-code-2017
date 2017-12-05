package aoc.day02;

import java.util.Arrays;
import java.util.regex.Pattern;

import aoc.Challenge;
import aoc.StdInput;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
public final class Day02 implements Challenge<Long> {

    private final Strategy strategy;

    private final Day02.Row[] rows;

    public Day02(final Strategy strategy) {
        this(strategy, new StdInput(2).read());
    }

    Day02(final Strategy strategy, final String input) {
        this(
            strategy,
            Arrays.stream(input.split("\n"))
                .map(Day02.Row::new)
                .toArray(Day02.Row[]::new)
        );
    }

    @Override
    public Long run() {
        long checksum = 0L;
        for (final Day02.Row row : this.rows) {
            checksum += this.strategy.apply(row);
        }
        return checksum;
    }

    @Data
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    public static final class Row {

        private static final Pattern PATTERN = Pattern.compile("(\\s)+");

        private final int[] data;

        public Row(final CharSequence input) {
            this(
                Arrays.stream(Day02.Row.PATTERN.split(input))
                    .mapToInt(Integer::parseUnsignedInt)
                    .toArray()
            );
        }

    }

}
