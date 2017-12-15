package aoc.day14;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

public interface Square {

    int row();

    int col();

    @Data
    @Accessors(fluent = true)
    @ToString
    @EqualsAndHashCode
    final class Default implements Square {

        private final int row;

        private final int col;

    }

}
