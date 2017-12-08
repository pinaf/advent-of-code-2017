package aoc.day08;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

public interface InstructionDef {

    ConditionDef condition();

    OperationDef operation();

    String register();

    @Data
    @Accessors(fluent = true)
    @ToString
    final class Default implements InstructionDef {

        private final String register;

        private final OperationDef operation;

        private final ConditionDef condition;

    }

}
