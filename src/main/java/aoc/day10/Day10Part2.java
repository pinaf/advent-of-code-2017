package aoc.day10;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

import aoc.Challenge;
import aoc.StdInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day10Part2 implements Challenge<String> {

    private final int[] tail = {17, 31, 73, 47, 23};

    private final int[] list;

    private final int[] input;

    public Day10Part2() {
        this(new StdInput(10).read());
    }

    public Day10Part2(final String input) {
        this(
            input.chars()
                .toArray()
        );
    }

    public Day10Part2(final int[] input) {
        this.input = new int[input.length + this.tail.length];
        System.arraycopy(input, 0, this.input, 0, input.length);
        System.arraycopy(this.tail, 0, this.input, input.length, this.tail.length);
        this.list = new int[256];
        for (int idx = 0; idx < this.list.length; ++idx) {
            this.list[idx] = idx;
        }
    }

    @Override
    public String run() {
        int pos = 0;
        int skip = 0;
        for (int round = 1; round <= 64; ++round) {
            for (final int length : this.input) {
                this.reverse(pos, length);
                pos = (pos + length + skip) % this.list.length;
                skip++;
            }
        }
        final int[] dense = new int[16];
        for (int block = 0; block < 16; ++block) {
            int xor = this.list[16 * block];
            for (int idx = 1; idx < 16; ++idx) {
                xor ^= this.list[16 * block + idx];
            }
            dense[block] = xor;
        }
        return Arrays.stream(dense)
            .mapToObj(n -> String.format("%02X", n).toLowerCase(Locale.ENGLISH))
            .collect(Collectors.joining(""));
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
