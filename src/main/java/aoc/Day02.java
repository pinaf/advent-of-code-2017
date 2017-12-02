package aoc;

import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Pattern;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
public final class Day02 implements Challenge<Long> {

    private final Day02.Strategy strategy;

    private final Day02.Row[] rows;

    public Day02(final Day02.Strategy strategy, final String... rows) {
        this(
            strategy,
            Arrays.stream(rows)
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

        private static final Pattern PATTERN = Pattern.compile("\\s");

        private final int[] data;

        public Row(final CharSequence input) {
            this(
                Arrays.stream(Day02.Row.PATTERN.split(input))
                    .mapToInt(Integer::parseUnsignedInt)
                    .toArray()
            );
        }

    }

    interface Strategy extends Function<Day02.Row, Long> {

        final class MinMax implements Day02.Strategy {

            @Override
            public Long apply(final Row row) {
                final int[] data = row.data();
                if (data.length < 1) {
                    return 0L;
                }
                int min = data[0];
                int max = min;
                for (int idx = 1; idx < data.length; ++idx) {
                    final int current = data[idx];
                    if (current < min) {
                        min = current;
                    }
                    if (current > max) {
                        max = current;
                    }
                }
                return (long) max - (long) min;
            }

        }

    }

}
