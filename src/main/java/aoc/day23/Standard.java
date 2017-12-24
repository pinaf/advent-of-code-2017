package aoc.day23;

import java.util.HashMap;
import java.util.Map;

public final class Standard implements InstructionMap {

    private final InstructionMap wrapped;

    public Standard() {
        final Map<String, Instruction> map = new HashMap<>(4);
        map.put("set", new InstrSet());
        map.put("sub", new InstrSub());
        map.put("mul", new InstrMul());
        map.put("jnz", new InstrJnz());
        this.wrapped = new InstructionMap.Generic(map);
    }

    @Override
    public Instruction get(final InstructionDef def) {
        return this.wrapped.get(def);
    }

}
