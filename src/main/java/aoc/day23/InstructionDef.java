package aoc.day23;

import lombok.Data;
import lombok.experimental.Accessors;

public interface InstructionDef {

    String mnemonic();

    String operand1();

    String operand2();

    @Data
    @Accessors(fluent = true)
    final class Default implements InstructionDef {

        private final String mnemonic;

        private final String operand1;

        private final String operand2;

        public Default(final String input) {
            final String[] split = InstructionDef.Default.sanitize(input).split(" ");
            this.mnemonic = split[0];
            this.operand1 = split[1];
            this.operand2 = split.length > 2 ? split[2] : "";
        }

        @Override
        public String toString() {
            return String.format("%s %s %s", this.mnemonic, this.operand1, this.operand2);
        }

        private static String sanitize(final String input) {
            String sanitized = input;
            final int comment = input.indexOf('#');
            if (comment >= 0) {
                sanitized = sanitized.substring(0, comment);
            }
            return sanitized.trim();
        }

    }

}
