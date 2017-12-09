package aoc.day08;

import java.util.Locale;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

public interface OperationDef {

    long operand();

    OperationDef.Type type();

    enum Type {
        INC,
        DEC
    }

    @Getter
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    @ToString
    final class Default implements OperationDef {

        private final long operand;

        private final OperationDef.Type type;

        Default(final String type, final long operand) {
            this(
                operand,
                OperationDef.Type.valueOf(type.toUpperCase(Locale.ENGLISH))
            );
        }

    }

}
