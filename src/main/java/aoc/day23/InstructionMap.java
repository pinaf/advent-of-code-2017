package aoc.day23;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

public interface InstructionMap {

    Instruction get(InstructionDef def);

    @RequiredArgsConstructor
    final class Generic implements InstructionMap {

        private final Map<String, Instruction> map;

        @Override
        public Instruction get(final InstructionDef def) {
            return this.map.get(def.mnemonic());
        }

    }

    @RequiredArgsConstructor
    final class Mutable implements InstructionMap {

        private final Map<String, Instruction> overrides = new HashMap<>(10);

        private final InstructionMap map;

        @Override
        public Instruction get(final InstructionDef def) {
            return Optional.ofNullable(this.overrides.get(def.mnemonic()))
                .orElse(this.map.get(def));
        }

        public InstructionMap.Mutable with(final String mnemonic, final Instruction instruction) {
            this.overrides.put(mnemonic, instruction);
            return this;
        }

    }


}
