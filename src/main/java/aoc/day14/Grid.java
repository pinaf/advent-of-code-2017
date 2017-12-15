package aoc.day14;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.RequiredArgsConstructor;

public interface Grid {

    int rows();

    IntStream row(int row);

    int get(int row, int col);

    default <T> Stream<T> flatMapRows(final Function<IntStream, T> map) {
        return IntStream.range(0, this.rows()).boxed()
            .map(this::row)
            .map(map);
    }

    default IntStream all() {
        return IntStream.range(0, this.rows())
            .flatMap(this::row);
    }

    default String rowAsString(final int row, final int cols) {
        final StringBuilder builder = new StringBuilder(100);
        for (int col = 0; col < cols; ++col) {
            builder.append(this.get(row, col));
        }
        return builder.toString();
    }

    default String viewport(final int rows, final int cols) {
        final StringBuilder builder = new StringBuilder(1000);
        for (int row = 0; row < rows; ++row) {
            builder.append(this.rowAsString(row, cols)).append('\n');
        }
        return builder.toString();
    }

    interface Mutable extends Grid {

        Grid set(int row, int col, int value);

        Grid setRow(int row, int[] values);

    }

    @RequiredArgsConstructor
    final class Simple implements Grid.Mutable {

        private final int[][] grid;

        Simple(final int rows, final int cols) {
            this(new int[rows][cols]);
        }

        @Override
        public int rows() {
            return this.grid.length;
        }

        @Override
        public IntStream row(final int row) {
            return Arrays.stream(this.grid[row]);
        }

        @Override
        public int get(final int row, final int col) {
            return this.grid[row][col];
        }

        @Override
        public Grid set(final int row, final int col, final int value) {
            this.grid[row][col] = value;
            return this;
        }

        @Override
        public Grid setRow(final int row, final int[] values) {
            System.arraycopy(values, 0, this.grid[row], 0, values.length);
            return this;
        }

    }

    @RequiredArgsConstructor
    abstract class GridWrap implements Grid {

        private final Grid wrapped;

        @Override
        public final int rows() {
            return this.wrapped.rows();
        }

        @Override
        public final IntStream row(final int row) {
            return this.wrapped.row(row);
        }

        @Override
        public final int get(final int row, final int col) {
            return this.wrapped.get(row, col);
        }

    }

}
