package aoc.day07;

import java.util.Collections;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

public interface ProgramInput {

    String name();

    long weight();

    List<String> children();

    @Data
    @Accessors(fluent = true)
    @EqualsAndHashCode(of = "name")
    @RequiredArgsConstructor
    @ToString
    final class Default implements ProgramInput {

        private final String name;

        private final long weight;

        private final List<String> children;

        Default(final String name, final long weight) {
            this(name, weight, Collections.emptyList());
        }

    }

}
