package aoc.day23;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

public interface Program {

    void runSingle();

    void run(int count);

    void run();

    State state();

    @Slf4j
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    final class Default implements Program {

        private final List<InstructionDef> definitions;

        private final List<Instruction> instructions;

        @Getter
        private final State state = new State.Default();

        public Default(final String input) {
            this(new Standard(), input);
        }

        public Default(final InstructionMap map, final String input) {
            this(
                map,
                Arrays.stream(input.split("\n"))
                    .map(InstructionDef.Default::new)
                    .collect(Collectors.toList())
            );
        }

        public Default(final InstructionMap map, final List<InstructionDef> defs) {
            this(
                defs,
                defs.stream()
                    .map(map::get)
                    .collect(Collectors.toList())
            );
        }

        @Override
        public void runSingle() {
            if (!this.finished()) {
                final int pc = this.state.programCounter();
                final Instruction instruction = this.instructions.get(pc);
                final InstructionDef def = this.definitions.get(pc);
                //log.info(def.toString());
                instruction.run(new InstructionEnv.Default(this.state, def));
                //log.info(this.state.toString());
            }
        }

        @Override
        public void run(final int count) {
            //log.info(this.state.toString());
            for (int idx = 0; idx < count; ++idx) {
                if (this.finished()) {
                    break;
                }
                this.runSingle();
            }
        }

        @Override
        public void run() {
            while (!this.finished()) {
                this.runSingle();
            }
            //log.info(this.state.toString());
        }

        private boolean finished() {
            final int pc = this.state.programCounter();
            return pc < 0 || pc >= this.instructions.size();
        }

    }

}
