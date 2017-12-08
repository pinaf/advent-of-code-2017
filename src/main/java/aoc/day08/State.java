package aoc.day08;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public interface State {

    Set<String> registers();

    long readRegister(String register);

    void incRegister(String register, long value);

    void decRegister(String register, long value);

    final class Default implements State {

        private final Map<String, Long> registers = new HashMap<>(100);

        @Override
        public Set<String> registers() {
            return this.registers.keySet();
        }

        @Override
        public long readRegister(final String register) {
            this.ensureRegister(register);
            return this.registers.get(register);
        }

        @Override
        public void incRegister(final String register, final long value) {
            this.ensureRegister(register);
            this.registers.put(register, this.readRegister(register) + value);
        }

        @Override
        public void decRegister(final String register, final long value) {
            this.ensureRegister(register);
            this.registers.put(register, this.readRegister(register) - value);
        }

        private void ensureRegister(final String register) {
            this.registers.putIfAbsent(register, 0L);
        }

    }

}
