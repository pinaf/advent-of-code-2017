package aoc.day12;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

public interface Pipe {

    Long left();

    long[] right();

    @Getter
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    @ToString
    final class Default implements Pipe {

        private final Long left;

        private final long[] right;

    }

}
