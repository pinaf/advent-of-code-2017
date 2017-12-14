package aoc.day14;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import aoc.day10.InputTransform;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public final class Day14 implements TwoPartChallenge<Long, Long> {

    private static final int[] TAIL = {17, 31, 73, 47, 23};

    private final String input;

    public Day14() {
        this(new StdInput(14).read());
    }

    @Override
    public Long part1() {
        final int[][] grid = this.buildGrid();
        long total = 0L;
        for (int row = 0; row < grid.length; ++row) {
            total += (long) Arrays.stream(grid[row]).sum();
        }
        return total;
    }

    @Override
    public Long part2() {
        final int[][] grid = this.buildGrid();
        final int[][] regions = new int[128][128];
        int next = 1;
        for (int row = 0; row < grid.length; ++row) {
            Optional<Square> match = this.nextInRow(row, regions, grid);
            while (match.isPresent()) {
                final Square current = match.get();
                this.processSquare(next, current, regions, grid);
                next++;
                match = this.nextInRow(row, regions, grid);
            }
        }
        for (int row = 0; row < grid.length; ++row) {
            log.info(this.rowAsString(regions[row]));
        }
        return Math.max(0L, (long) next - 1L);
    }

    private Optional<Square> nextInRow(final int row, final int[][] regions, final int[][] grid) {
        final OptionalInt match = IntStream.range(0, 128)
            .filter(col -> grid[row][col] != 0 && regions[row][col] == 0)
            .findFirst();
        if (match.isPresent()) {
            return Optional.of(new Square(row, match.getAsInt()));
        } else {
            return Optional.empty();
        }
    }

    private List<Square> usedNeighbors(final Square square, final int[][] regions, final int[][] grid) {
        final int row = square.row();
        final int col = square.col();
        return Stream.of(
            new Square(row, col - 1),
            new Square(row, col + 1),
            new Square(row - 1, col),
            new Square(row + 1, col)
        )
            .filter(sq -> sq.row() >= 0 && sq.row() < 128 && sq.col() >= 0 && sq.col() < 128)
            .filter(sq -> grid[sq.row()][sq.col()] != 0 && regions[sq.row()][sq.col()] == 0)
            .collect(Collectors.toList());
    }

    private void processSquare(final int value, final Square square, final int[][] regions, final int[][] grid) {
        regions[square.row()][square.col()] = value;
        log.info("[{}, {}] -> {}", square.row(), square.col(), value);
        final List<Square> neighbors = this.usedNeighbors(square, regions, grid);
        while (!neighbors.isEmpty()) {
            final Square neighbor = neighbors.get(0);
            neighbors.remove(neighbor);
            this.processSquare(value, neighbor, regions, grid);
        }
    }

    private int[][] buildGrid() {
        final int[][] grid = new int[128][128];
        for (int row = 0; row < 128; ++row) {
            final String label = String.format("%s-%d", this.input, row);
            final int[] hash = this.knotHash(
                new InputTransform.AppendTail(Day14.TAIL).apply(label.chars().toArray()),
                64
            );
            //log.info("Row {} Label {} Hash {}", row, label, this.hashHex(hash));
            System.arraycopy(this.buildRow(hash), 0, grid[row], 0, 128);
        }
        for (int row = 0; row < 8; ++row) {
            log.info(this.rowAsString(grid[row]));
        }
        return grid;
    }

    private int[] buildRow(final int[] hash) {
        final int[] row = new int[128];
        for (int col = 0; col < 128; ++col) {
            final int info = hash[col / 8];
            row[col] = (info & (1 << (7 - col % 8))) == 0 ? 0 : 1;
        }
        log.info(this.rowAsString(row));
        return row;
    }

    private String rowAsString(final int[] row) {
        final StringBuilder builder = new StringBuilder(8);
        for (int col = 0; col < 8; ++col) {
            builder.append(row[col]);
        }
        return builder.toString();
    }

    private int countBits(final int value) {
        int total = 0;
        for (int idx = 0; idx < 8; ++idx) {
            total += (value & (1 << idx)) != 0 ? 1 : 0;
        }
        return total;
    }

    private String hashHex(final int[] list) {
        return Arrays.stream(list)
            .mapToObj(n -> String.format("%02X", n).toLowerCase(Locale.ENGLISH))
            .collect(Collectors.joining(""));
    }

    private int[] knotHash(final int[] lengths, final int rounds) {
        final int[] list = this.buildList(256);
        int pos = 0;
        int skip = 0;
        for (int round = 1; round <= rounds; ++round) {
            for (final int length : lengths) {
                this.reverse(pos, length, list);
                pos = (pos + length + skip) % list.length;
                skip++;
            }
        }
        return this.dense(list);
    }

    private int[] dense(final int[] list) {
        final int[] dense = new int[16];
        for (int block = 0; block < 16; ++block) {
            int xor = list[16 * block];
            for (int idx = 1; idx < 16; ++idx) {
                xor ^= list[16 * block + idx];
            }
            dense[block] = xor;
        }
        return dense;
    }

    private int[] buildList(final int length) {
        final int[] list = new int[length];
        for (int idx = 0; idx < list.length; ++idx) {
            list[idx] = idx;
        }
        return list;
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
