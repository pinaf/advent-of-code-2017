package aoc.day12;

import java.util.Arrays;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

public interface Pipe {

    long left();

    long[] right();

    @Getter
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    @ToString
    final class Default implements Pipe {

        private final long left;

        private final long[] right;

        public Default(final String input) {
            this(input.split(" <-> "));
        }

        public Default(final String[] split) {
            this(
                Long.parseLong(split[0]),
                Arrays.stream(split[1].trim().split(", ")).mapToLong(Long::parseLong).toArray()
            );
        }

    }

}
