package aoc.day14;

import aoc.day10.KnotHash;

final class UsageHashGrid extends Grid.GridWrap {

    static final int ROWS = 128;

    static final int COLS = 128;

    UsageHashGrid(final String input) {
        super(UsageHashGrid.buildGrid(input));
    }

    private static Grid buildGrid(final String input) {
        final KnotHash knot = new KnotHash.Dense();
        final Grid.Mutable grid = new Grid.Simple(UsageHashGrid.ROWS, UsageHashGrid.COLS);
        for (int row = 0; row < grid.rows(); ++row) {
            final String label = String.format("%s-%d", input, row);
            final int[] hash = knot.hash(label.chars().toArray());
            grid.setRow(row, UsageHashGrid.buildRow(hash));
        }
        return grid;
    }

    private static int[] buildRow(final int[] hash) {
        final int[] row = new int[UsageHashGrid.COLS];
        for (int col = 0; col < row.length; ++col) {
            final int info = hash[col / 8];
            row[col] = (info & 1 << 7 - col % 8) == 0 ? 0 : 1;
        }
        return row;
    }

}
