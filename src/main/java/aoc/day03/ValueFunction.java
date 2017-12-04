package aoc.day03;

import java.util.function.Function;

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

}
