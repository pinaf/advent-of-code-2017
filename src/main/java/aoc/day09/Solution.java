package aoc.day09;

import java.util.function.Function;

public interface Solution extends Function<State, Long> {

    final class TotalGroupScore implements Solution {
        @Override
        public Long apply(final State state) {
            return state.score();
        }
    }

    final class TotalGarbageSeen implements Solution {
        @Override
        public Long apply(final State state) {
            return state.garbage();
        }
    }

}
