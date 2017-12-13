package aoc.day02;

import java.util.Arrays;

import aoc.Challenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day02Common implements Challenge<Long> {

    private final Strategy strategy;

    private final Row[] rows;

    Day02Common(final Strategy strategy, final String input) {
        this(
            strategy,
            Arrays.stream(input.split("\n"))
                .map(Row.Default::new)
                .toArray(Row.Default[]::new)
        );
    }

    @Override
    public Long run() {
        long checksum = 0L;
        for (final Row row : this.rows) {
            checksum += this.strategy.apply(row);
        }
        return checksum;
    }

}
