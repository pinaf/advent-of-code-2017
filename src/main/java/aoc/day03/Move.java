package aoc.day03;

import java.util.function.Function;

interface Move extends Function<State, State> {

    final class Right implements Move {
        @Override
        public State apply(final State state) {
            return new State.Default(
                state.x() + 1L,
                state.y(),
                state.value()
            );
        }
    }

    final class Up implements Move {
        @Override
        public State apply(final State state) {
            return new State.Default(
                state.x(),
                state.y() + 1L,
                state.value()
            );
        }
    }

    final class Left implements Move {
        @Override
        public State apply(final State state) {
            return new State.Default(
                state.x() - 1L,
                state.y(),
                state.value()
            );
        }
    }

    final class Down implements Move {
        @Override
        public State apply(final State state) {
            return new State.Default(
                state.x(),
                state.y() - 1L,
                state.value()
            );
        }
    }

}
