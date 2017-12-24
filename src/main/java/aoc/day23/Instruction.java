package aoc.day23;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

public interface Instruction {

    void run(InstructionEnv env);

    @Accessors(fluent = true)
    @RequiredArgsConstructor
    final class InstrCounting implements Instruction {

        private final Instruction instruction;

        @Getter
        private long count;

        @Override
        public void run(final InstructionEnv env) {
            this.instruction.run(env);
            this.count++;
        }

    }

}
