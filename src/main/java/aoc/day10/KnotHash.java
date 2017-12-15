package aoc.day10;

import lombok.RequiredArgsConstructor;

public interface KnotHash {

    default int[] hash(final String input) {
        return this.hash(input.chars().toArray());
    }

    int[] hash(int[] input);

    @RequiredArgsConstructor
    final class Simple implements KnotHash {

        private final int length;

        private final int rounds;

        public Simple(final int length) {
            this(length, 1);
        }

        @Override
        public int[] hash(final int[] input) {
            final int[] list = this.buildInitialList();
            int pos = 0;
            int skip = 0;
            for (int round = 1; round <= this.rounds; ++round) {
                for (final int current : input) {
                    this.reverse(pos, current, list);
                    pos = (pos + current + skip) % list.length;
                    skip++;
                }
            }
            return list;
        }

        private int[] buildInitialList() {
            final int[] initial = new int[this.length];
            for (int idx = 0; idx < initial.length; ++idx) {
                initial[idx] = idx;
            }
            return initial;
        }

        private void reverse(final int pos, final int length, final int[] list) {
            final int[] copy = new int[length];
            int current = pos;
            for (int idx = 0; idx < length; ++idx) {
                copy[idx] = list[current];
                current = (current + 1) % list.length;
            }
            current = pos;
            for (int idx = 0; idx < length; ++idx) {
                list[current] = copy[length - 1 - idx];
                current = (current + 1) % list.length;
            }
        }

    }

    @RequiredArgsConstructor
    final class Dense implements KnotHash {

        private static final int[] TAIL = {17, 31, 73, 47, 23};

        private final InputTransform transform;

        private final KnotHash wrapped;

        public Dense() {
            this(256, 64);
        }

        public Dense(final int length, final int rounds) {
            this(new InputTransform.AppendTail(KnotHash.Dense.TAIL), length, rounds);
        }

        public Dense(final InputTransform transform, final int length, final int rounds) {
            this.transform = transform;
            this.wrapped = new Simple(length, rounds);
        }

        @Override
        public int[] hash(final int[] input) {
            return new Solution.DenseHash().apply(this.wrapped.hash(this.transform.apply(input)));
        }

    }

}
