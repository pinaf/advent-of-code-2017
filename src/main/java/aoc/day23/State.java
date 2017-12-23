package aoc.day23;

import java.util.HashMap;
import java.util.Map;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

public interface State {

    long readRegister(String register);

    void setRegister(String register, long value);

    @Slf4j
    @ToString
    final class Default implements State {

        private final Map<String, Long> registers = new HashMap<>(100);

        @Override
        public long readRegister(final String register) {
            this.ensureRegister(register);
            return this.registers.get(register);
        }

        @Override
        public void setRegister(final String register, final long value) {
            this.ensureRegister(register);
            this.registers.put(register, value);
            if ("h".equals(register)) {
                log.info("{} = {}", register, value);
            }
        }

        private void ensureRegister(final String register) {
            this.registers.putIfAbsent(register, 0L);
        }

    }

}
