package aoc.day22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
public final class GridSimple implements Grid {

    private final int size;

    private final List<int[]> rows;

    public GridSimple(final int size) {
        this.size = size;
        this.rows = new ArrayList<>(size);
        for (int idx = 0; idx < size; ++idx) {
            final int[] row = new int[size];
            for (int jdx = 0; jdx < size; ++jdx) {
                row[jdx] = Grid.CLEAN;
            }
            this.rows.add(row);
        }
    }

    public GridSimple(final String input) {
        this(input, "\n");
    }

    public GridSimple(final String input, final String split) {
        this(Arrays.stream(input.split(split)).collect(Collectors.toList()));
    }

    public GridSimple(final Collection<String> input) {
        this(
            input.size(),
            input.stream()
                .map(GridSimple::parseRow)
                .collect(Collectors.toList())
        );
    }

    @Override
    public String toString() {
        return this.asString();
    }

    @Override
    public void set(final int r, final int c, final int v) {
        this.rows.get(r)[c] = v;
    }

    @Override
    public int get(final int r, final int c) {
        return this.rows.get(r)[c];
    }

    private static int[] parseRow(final CharSequence row) {
        return row.chars().toArray();
    }

}
