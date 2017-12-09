package aoc.day08;

import java.util.Arrays;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

public interface ConditionDef {

    String register();

    long operand();

    ConditionDef.Type type();

    @Getter
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    enum Type {

        GT(">"),
        GTE(">="),
        LT("<"),
        LTE("<="),
        EQ("=="),
        NEQ("!=");

        private final String symbol;

        public static ConditionDef.Type fromSymbol(final String symbol) {
            return Arrays.stream(ConditionDef.Type.values())
                .filter(type -> type.symbol().equals(symbol))
                .findFirst()
                .get();
        }

        @Override
        public String toString() {
            return this.symbol;
        }
    }

    @Data
    @Accessors(fluent = true)
    @ToString
    final class Default implements ConditionDef {

        private final String register;

        private final long operand;

        private final ConditionDef.Type type;

        static ConditionDef parse(final String input) {
            final String[] split = input.trim().split("\\s+");
            return new ConditionDef.Default(
                split[0],
                Long.parseLong(split[2]),
                ConditionDef.Type.fromSymbol(split[1])
            );
        }

    }

}
