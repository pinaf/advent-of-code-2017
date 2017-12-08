package aoc.day08;

import lombok.RequiredArgsConstructor;

public interface Instruction {

    void run(State state);

    @RequiredArgsConstructor
    final class Default implements Instruction {

        private final InstructionDef def;

        @Override
        public void run(final State state) {
            if (new Condition.Default(this.def.condition()).check(state)) {
                new Operation.Default(this.def.operation()).apply(this.def.register(), state);
            }
        }

    }

}
