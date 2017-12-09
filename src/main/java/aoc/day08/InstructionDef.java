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

        static InstructionDef parse(final String input) {
            final String[] ifsplit = input.split(" if ");
            final String[] opsplit = ifsplit[0].trim().split("\\s+");
            return new InstructionDef.Default(
                opsplit[0],
                new OperationDef.Default(opsplit[1], Long.parseLong(opsplit[2])),
                ConditionDef.Default.parse(ifsplit[1])
            );
        }

    }

}
