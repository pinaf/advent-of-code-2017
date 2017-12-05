package aoc.day05;

import java.util.function.Function;

public interface Operation extends Function<Integer, Integer> {

    final class Increment implements Operation {
        @Override
        public Integer apply(final Integer value) {
            return value + 1;
        }
    }

}
