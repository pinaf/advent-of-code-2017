package aoc.day08;

public interface Solution {

    void notifyState(State state);

    long get();

    final class HighestFinalRegister implements Solution {

        private long current;

        @Override
        public void notifyState(final State state) {
            this.current = state.registers().stream().mapToLong(state::readRegister).max().orElse(0L);
        }

        @Override
        public long get() {
            return this.current;
        }

    }

    final class HighestAllTimeRegister implements Solution {

        private long highest;

        @Override
        public void notifyState(final State state) {
            final long current = state.registers().stream().mapToLong(state::readRegister).max().orElse(0L);
            if (current > this.highest) {
                this.highest = current;
            }
        }

        @Override
        public long get() {
            return this.highest;
        }

    }

}
