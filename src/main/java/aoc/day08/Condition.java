package aoc.day08;

import lombok.RequiredArgsConstructor;

public interface Condition {

    boolean check(State state);

    @RequiredArgsConstructor
    final class Default implements Condition {

        private final ConditionDef def;

        @Override
        public boolean check(final State state) {
            switch (this.def.type()) {
                case GT:
                    return state.readRegister(this.def.register()) > this.def.operand();
                case GTE:
                    return state.readRegister(this.def.register()) >= this.def.operand();
                case LT:
                    return state.readRegister(this.def.register()) < this.def.operand();
                case LTE:
                    return state.readRegister(this.def.register()) <= this.def.operand();
                case EQ:
                    return state.readRegister(this.def.register()) == this.def.operand();
                case NEQ:
                    return state.readRegister(this.def.register()) != this.def.operand();
            }
            throw new IllegalStateException("Should never get here...");
        }

    }

}
