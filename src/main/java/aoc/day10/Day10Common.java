package aoc.day10;

import aoc.Challenge;

public final class Day10Common<T> implements Challenge<T> {

    private final int[] list;

    private final Solution<T> solution;

    private final int rounds;

    private final int[] lengths;

    Day10Common(final Solution<T> solution, final InputTransform transform, final int length, final int[] lengths, final int rounds) {
        this.solution = solution;
        this.rounds = rounds;
        this.lengths = transform.apply(lengths);
        this.list = Day10Common.buildList(length);
    }

    @Override
    public T run() {
        int pos = 0;
        int skip = 0;
        for (int round = 1; round <= this.rounds; ++round) {
            for (final int length : this.lengths) {
                this.reverse(pos, length);
                pos = (pos + length + skip) % this.list.length;
                skip++;
            }
        }
        return this.solution.apply(this.list);
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
