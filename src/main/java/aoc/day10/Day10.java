package aoc.day10;

import java.util.Arrays;

import aoc.Challenge;
import aoc.StdInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day10 implements Challenge<Long> {

    private final int[] list;

    private final int[] input;

    public Day10() {
        this(new StdInput(10).read());
    }

    public Day10(final String input) {
        this(
            Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .toArray()
        );
    }

    public Day10(final int[] input) {
        this.input = input;
        this.list = new int[256];
        for (int idx = 0; idx < this.list.length; ++idx) {
            this.list[idx] = idx;
        }
    }

    @Override
    public Long run() {
        int pos = 0;
        int skip = 0;
        for (final int length : this.input) {
            this.reverse(pos, length);
            pos = (pos + length + skip) % this.list.length;
            skip++;
        }
        return (long) this.list[0] * (long) this.list[1];
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
