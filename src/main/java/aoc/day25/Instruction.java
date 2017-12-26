package aoc.day25;

import lombok.Data;
import lombok.experimental.Accessors;

public interface Instruction {

    int value();

    int move();

    String state();

    @Data
    @Accessors(fluent = true)
    final class Default implements Instruction {

        private final int value;

        private final int move;

        private final String state;

    }

}
