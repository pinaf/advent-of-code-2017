package aoc.day07;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

public interface ProgramInfo {

    String name();

    long weight();

    @Getter
    @Accessors(fluent = true)
    @EqualsAndHashCode
    @RequiredArgsConstructor
    @ToString
    final class Default implements ProgramInfo {

        private final String name;

        private final long weight;

    }

}
