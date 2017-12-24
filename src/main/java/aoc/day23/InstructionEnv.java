package aoc.day23;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

public interface InstructionEnv {

    State state();

    String operand1();

    long operand2();

    long eval(String operand);

    @Accessors(fluent = true)
    @RequiredArgsConstructor
    final class Default implements InstructionEnv {

        @Getter
        private final State state;

        private final InstructionDef def;

        @Override
        public String operand1() {
            return this.def.operand1();
        }

        @Override
        public long operand2() {
            return this.eval(this.def.operand2());
        }

        @Override
        public long eval(final String operand) {
            final char first = operand.charAt(0);
            final long value;
            if (first >= '0' && first <= '9' || first == '-') {
                value = Long.parseLong(operand);
            } else {
                value = this.state.readRegister(operand);
            }
            return value;
        }

    }

}
