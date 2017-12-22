package aoc.day22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

public interface Pattern {

    int size();

    void flip(int r, int c);

    void set(int r, int c, int v);

    void incMod4(int r, int c);

    int on(int r, int c);

    default boolean eq(final Pattern pattern) {
        if (pattern.size() != this.size()) {
            return false;
        }
        return IntStream.range(0, this.size()).allMatch(r ->
            IntStream.range(0, this.size()).allMatch(c ->
                this.on(r, c) == pattern.on(r, c)
            )
        );
    }

    default long pixelsOn() {
        return (long) IntStream.range(0, this.size())
            .map(r -> IntStream.range(0, this.size()).map(c -> this.on(r, c)).sum())
            .sum();
    }

    default List<Pattern> split() {
        final int length = IntStream.range(2, 4)
            .filter(n -> this.size() % n == 0)
            .findFirst().getAsInt();
        final int count = this.size() / length;
        final List<Pattern> patterns = new ArrayList<>(count * count);
        for (int idx = 0; idx < count; ++idx) {
            for (int jdx = 0; jdx < count; ++jdx) {
                patterns.add(this.subPattern(idx * length, jdx * length, length));
            }
        }
        return patterns;
    }

    default Pattern subPattern(final int row, final int col, final int length) {
        return new Pattern.Default(
            length,
            IntStream.range(0, length).mapToObj(r ->
                IntStream.range(0, length).map(c -> this.on(row + r, col + c)).toArray()
            ).collect(Collectors.toList())
        );
    }

    default String asString() {
        return IntStream.range(0, this.size())
            .mapToObj(this::printRow)
            .collect(Collectors.joining("\n"));
    }

    default String printRow(final int row) {
        return IntStream.range(0, this.size())
            .mapToObj(i -> {
                final int value = this.on(row, i);
                final String s;
                if (value == 0) {
                    s = ".";
                } else if (value == 1) {
                    s = "W";
                } else if (value == 2) {
                    s = "#";
                } else {
                    s = "F";
                }
                return s;
            })
            .collect(Collectors.joining(""));
    }

    @Getter
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    @EqualsAndHashCode
    final class Default implements Pattern {

        private final int size;

        private final List<int[]> grid;

        public Default(final int size) {
            this.size = size;
            this.grid = new ArrayList<>(size);
            for (int idx = 0; idx < size; ++idx) {
                this.grid.add(new int[size]);
            }
        }

        public Default(final String input) {
            this(input, "\n");
        }

        public Default(final String input, final String split) {
            this(Arrays.stream(input.split(split)).collect(Collectors.toList()));
        }

        public Default(final Collection<String> input) {
            this(
                input.size(),
                input.stream()
                    .map(Default::parseRow)
                    .collect(Collectors.toList())
            );
        }

        @Override
        public String toString() {
            return this.asString();
        }

        @Override
        public void flip(final int r, final int c) {
            final int current = this.grid.get(r)[c];
            this.grid.get(r)[c] = current == 0 ? 1 : 0;
        }

        @Override
        public void set(final int r, final int c, final int v) {
            this.grid.get(r)[c] = v;
        }

        @Override
        public void incMod4(final int r, final int c) {
            final int current = this.grid.get(r)[c];
            this.grid.get(r)[c] = (current + 1) % 4;
        }

        @Override
        public int on(final int r, final int c) {
            return this.grid.get(r)[c];
        }

        private static int[] parseRow(final CharSequence row) {
            return row.chars().map(c -> c == '.' ? 0 : 1).toArray();
        }

    }

}
