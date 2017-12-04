package aoc.day03;

import java.util.function.Function;
import java.util.stream.LongStream;

interface ValueFunction extends Function<State, Long> {

    final class Increment implements ValueFunction {
        @Override
        public Long apply(final State state) {
            return state.value() + 1L;
        }
    }

    final class ManhattanDistanceToOrigin implements ValueFunction {
        @Override
        public Long apply(final State state) {
            return Math.abs(state.x()) + Math.abs(state.y());
        }
    }

    final class StateValue implements ValueFunction {
        @Override
        public Long apply(final State state) {
            return state.value();
        }
    }

    final class SumOfNeighbors implements ValueFunction {

        private final Memory2D memory = new Memory2D.Default();

        public SumOfNeighbors() {
            this.memory.write(0L, 0L, 1L);
        }

        @Override
        public Long apply(final State state) {
            final long sum = LongStream.of(-1L, 0L, 1L).flatMap(x ->
                LongStream.of(-1L, 0L, 1L).map(y ->
                    this.memory.read(state.x() + x, state.y() + y))
            ).sum();
            this.memory.write(state.x(), state.y(), sum);
            return sum;
        }

    }

}
