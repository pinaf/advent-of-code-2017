package aoc.day05;

import java.util.function.Function;

public interface Operation extends Function<Integer, Integer> {

    final class Increment implements Operation {
        @Override
        public Integer apply(final Integer value) {
            return value + 1;
        }
    }

    final class Conditional implements Operation {
        @Override
        public Integer apply(final Integer value) {
            return value >= 3 ?
                value - 1 :
                value + 1;
        }
    }

}
