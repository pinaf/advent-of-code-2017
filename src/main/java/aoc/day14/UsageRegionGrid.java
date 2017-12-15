package aoc.day14;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class UsageRegionGrid extends Grid.GridWrap {

    private static final int ROWS = UsageHashGrid.ROWS;

    private static final int COLS = UsageHashGrid.COLS;

    UsageRegionGrid(final Grid grid) {
        super(UsageRegionGrid.buildRegionGrid(grid));
    }

    private static Grid buildRegionGrid(final Grid grid) {
        final Grid.Mutable regions = new Grid.Simple(UsageRegionGrid.ROWS, UsageRegionGrid.COLS);
        int next = 1;
        for (int row = 0; row < grid.rows(); ++row) {
            Optional<Square> match = UsageRegionGrid.nextInRow(row, regions, grid);
            while (match.isPresent()) {
                final Square square = match.get();
                UsageRegionGrid.processSquare(next, square, regions, grid);
                next++;
                match = UsageRegionGrid.nextInRow(row, regions, grid);
            }
        }
        return regions;
    }

    private static Optional<Square> nextInRow(final int row, final Grid regions, final Grid grid) {
        final OptionalInt match = IntStream.range(0, UsageRegionGrid.COLS)
            .filter(col -> grid.get(row, col) != 0 && regions.get(row, col) == 0)
            .findFirst();
        if (match.isPresent()) {
            return Optional.of(new Square.Default(row, match.getAsInt()));
        } else {
            return Optional.empty();
        }
    }

    private static List<Square> usedNeighbors(final Square square, final Grid regions, final Grid grid) {
        final int row = square.row();
        final int col = square.col();
        return Stream.of(
            new Square.Default(row, col - 1),
            new Square.Default(row, col + 1),
            new Square.Default(row - 1, col),
            new Square.Default(row + 1, col)
        )
            .filter(sq -> sq.row() >= 0 && sq.row() < UsageRegionGrid.ROWS && sq.col() >= 0 && sq.col() < UsageRegionGrid.COLS)
            .filter(sq -> grid.get(sq.row(), sq.col()) != 0 && regions.get(sq.row(), sq.col()) == 0)
            .collect(Collectors.toList());
    }

    private static void processSquare(final int value, final Square square, final Grid.Mutable regions, final Grid grid) {
        regions.set(square.row(), square.col(), value);
        final List<Square> neighbors = UsageRegionGrid.usedNeighbors(square, regions, grid);
        while (!neighbors.isEmpty()) {
            final Square neighbor = neighbors.get(0);
            neighbors.remove(neighbor);
            UsageRegionGrid.processSquare(value, neighbor, regions, grid);
        }
    }

}
