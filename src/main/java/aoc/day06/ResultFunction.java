package aoc.day06;

import java.util.function.BiFunction;

public interface ResultFunction extends BiFunction<Long, Integer, Long> {

    final class TotalSteps implements ResultFunction {
        @Override
        public Long apply(final Long steps, final Integer index) {
            return steps;
        }
    }

    final class CycleSize implements ResultFunction {
        @Override
        public Long apply(final Long steps, final Integer index) {
            return steps - index;
        }
    }

}
