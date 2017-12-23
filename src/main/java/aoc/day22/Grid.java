package aoc.day22;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Grid {

    char CLEAN = '.';

    char INFECTED = '#';

    char WEAKENED = 'W';

    char FLAGGED = 'F';

    int size();

    void set(int r, int c, int v);

    int get(int r, int c);

    default String asString() {
        return IntStream.range(0, this.size())
            .mapToObj(this::printRow)
            .collect(Collectors.joining("\n"));
    }

    default String printRow(final int row) {
        return IntStream.range(0, this.size())
            .mapToObj(i -> {
                final char value = (char) this.get(row, i);
                return String.valueOf(value);
            })
            .collect(Collectors.joining(""));
    }

}
