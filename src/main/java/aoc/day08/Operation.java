package aoc.day08;

import lombok.RequiredArgsConstructor;

public interface Operation {

    void apply(String register, State state);

    @RequiredArgsConstructor
    final class Default implements Operation {

        private final OperationDef def;

        @Override
        public void apply(final String register, final State state) {
            switch (this.def.type()) {
                case INC:
                    state.incRegister(register, this.def.operand());
                    break;
                case DEC:
                    state.decRegister(register, this.def.operand());
                    break;
            }
        }

    }

}
