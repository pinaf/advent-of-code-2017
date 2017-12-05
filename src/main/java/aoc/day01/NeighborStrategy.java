package aoc.day01;

import java.util.function.Function;

public interface NeighborStrategy extends Function<Integer, Function<Integer, Integer>> {

    final class Next implements NeighborStrategy {
        @Override
        public Function<Integer, Integer> apply(final Integer length) {
            return n -> (n + 1) % length;
        }
    }

    final class HalfAround implements NeighborStrategy {
        @Override
        public Function<Integer, Integer> apply(final Integer length) {
            return n -> (n + length / 2) % length;
        }
    }

}
