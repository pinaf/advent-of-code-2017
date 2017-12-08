package aoc.day08;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

public interface OperationDef {

    long operand();

    OperationDef.Type type();

    enum Type {
        INC,
        DEC
    }

    @Data
    @Accessors(fluent = true)
    @ToString
    final class Default implements OperationDef {

        private final long operand;

        private final OperationDef.Type type;

    }

}
