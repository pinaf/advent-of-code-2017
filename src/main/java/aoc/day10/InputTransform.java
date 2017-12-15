package aoc.day10;

import java.util.function.Function;

import lombok.RequiredArgsConstructor;

public interface InputTransform extends Function<int[], int[]> {

    final class Identity implements InputTransform {
        @Override
        public int[] apply(final int[] input) {
            return input;
        }
    }

    @RequiredArgsConstructor
    final class AppendTail implements InputTransform {

        private final int[] tail;

        @Override
        public int[] apply(final int[] input) {
            final int[] edited = new int[input.length + this.tail.length];
            System.arraycopy(input, 0, edited, 0, input.length);
            System.arraycopy(this.tail, 0, edited, input.length, this.tail.length);
            return edited;
        }

    }

}
