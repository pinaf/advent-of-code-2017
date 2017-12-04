package aoc.day03;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

interface State {

    long x();

    long y();

    long value();

    @Getter
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    final class Default implements State {

        private final long x;

        private final long y;

        private final long value;

        public Default() {
            this(0L, 0L, 1L);
        }

    }

}
