package aoc.day10;

import java.util.Arrays;

import aoc.Challenge;
import aoc.StdInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day10 implements Challenge<Long> {

    private final int[] list;

    private final int[] lengths;

    public Day10() {
        this(256, new StdInput(10).read());
    }

    public Day10(final int length, final String lengths) {
        this(
            length,
            Arrays.stream(lengths.split(","))
                .mapToInt(Integer::parseInt)
                .toArray()
        );
    }

    public Day10(final int length, final int[] lengths) {
        this.lengths = lengths;
        this.list = Day10.buildList(length);
    }

    @Override
    public Long run() {
        int pos = 0;
        int skip = 0;
        for (final int length : this.lengths) {
            this.reverse(pos, length);
            pos = (pos + length + skip) % this.list.length;
            skip++;
        }
        return (long) this.list[0] * (long) this.list[1];
    }

    private static int[] buildList(final int length) {
        final int[] list = new int[length];
        for (int idx = 0; idx < list.length; ++idx) {
            list[idx] = idx;
        }
        return list;
    }

    private void reverse(final int pos, final int length) {
        final int[] copy = new int[length];
        int current = pos;
        for (int idx = 0; idx < length; ++idx) {
            copy[idx] = this.list[current];
            current = (current + 1) % this.list.length;
        }
        current = pos;
        for (int idx = 0; idx < length; ++idx) {
            this.list[current] = copy[length - 1 - idx];
            current = (current + 1) % this.list.length;
        }
    }

}
