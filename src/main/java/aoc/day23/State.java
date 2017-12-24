package aoc.day23;

import java.util.HashMap;
import java.util.Map;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

public interface State {

    int programCounter();

    void incrementProgramCounter();

    void jump(int offset);

    long readRegister(String register);

    void setRegister(String register, long value);

    @Slf4j
    @ToString
    final class Default implements State {

        private final Map<String, Long> registers = new HashMap<>(100);

        private int pc;

        @Override
        public int programCounter() {
            return this.pc;
        }

        @Override
        public void incrementProgramCounter() {
            this.pc++;
        }

        @Override
        public void jump(final int offset) {
            this.pc += offset;
        }

        @Override
        public long readRegister(final String register) {
            this.ensureRegister(register);
            return this.registers.get(register);
        }

        @Override
        public void setRegister(final String register, final long value) {
            this.ensureRegister(register);
            this.registers.put(register, value);
        }

        private void ensureRegister(final String register) {
            this.registers.putIfAbsent(register, 0L);
        }

    }

}
