package aoc.day10;

import java.util.Arrays;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Solution<T> extends Function<int[], T> {

    final class ProductOfFirstTwo implements Solution<Long> {
        @Override
        public Long apply(final int[] list) {
            return (long) list[0] * (long) list[1];
        }
    }

    final class DenseHash implements Solution<int[]> {
        @Override
        public int[] apply(final int[] list) {
            final int[] dense = new int[16];
            for (int block = 0; block < 16; ++block) {
                int xor = list[16 * block];
                for (int idx = 1; idx < 16; ++idx) {
                    xor ^= list[16 * block + idx];
                }
                dense[block] = xor;
            }
            return dense;
        }
    }

    final class HashHex implements Solution<String> {
        @Override
        public String apply(final int[] list) {
            return Arrays.stream(list)
                .mapToObj(n -> String.format("%02X", n).toLowerCase(Locale.ENGLISH))
                .collect(Collectors.joining(""));
        }
    }

}
