package aoc.day02;

import java.util.function.Function;

public interface Strategy extends Function<Row, Long> {

    final class MinMax implements Strategy {
        @Override
        public Long apply(final Row row) {
            final int[] data = row.data();
            if (data.length < 1) {
                return 0L;
            }
            int min = data[0];
            int max = min;
            for (int idx = 1; idx < data.length; ++idx) {
                final int current = data[idx];
                if (current < min) {
                    min = current;
                }
                if (current > max) {
                    max = current;
                }
            }
            return (long) max - (long) min;
        }
    }

    final class EvenlyDivisible implements Strategy {
        @Override
        public Long apply(final Row row) {
            final int[] data = row.data();
            for (int idx = 0; idx < data.length; ++idx) {
                final int left = data[idx];
                for (int jdx = 0; jdx < data.length; ++jdx) {
                    if (jdx == idx) {
                        continue;
                    }
                    final int right = data[jdx];
                    if (right % left == 0) {
                        return (long) right / (long) left;
                    }
                }
            }
            return 0L;
        }
    }

}
