package aoc.day19;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public final class Day19 implements TwoPartChallenge<String, Long> {

    private final List<String> input;

    private final Collection<String> letters = new ArrayList<>(100);

    private long steps;

    public Day19() {
        this(new StdInput(19, false).read());
    }

    public Day19(final String input) {
        this(
            Arrays.stream(input.split("\n"))
                .collect(Collectors.toList())
        );
    }

    @Override
    public String part1() {
        this.route();
        return this.letters.stream().collect(Collectors.joining(""));
    }

    @Override
    public Long part2() {
        this.route();
        return this.steps;
    }

    private void route() {
        int x = this.findStart();
        int y = 0;
        char dir = 'd';
        char current = '|';
        this.printPosition(x, y, current, dir);
        this.steps++;
        do {
            switch (dir) {
                case 'd':
                    y++;
                    break;
                case 'u':
                    y--;
                    break;
                case 'l':
                    x--;
                    break;
                case 'r':
                    x++;
                    break;
            }
            this.steps++;
            current = this.charAt(x, y);
            if (current >= 'A' && current <= 'Z') {
                this.letters.add(new String(new char[] {current}));
            }
            dir = this.direction(x, y, dir, current);
            this.printPosition(x, y, current, dir);
        } while (dir != ' ');
    }

    private void printPosition(final int x, final int y, final char c, final char dir) {
        log.info("({}, {}) -> {}, dir = {}", x, y, c, dir);
    }

    private int findStart() {
        int pos = 0;
        final char[] line = this.input.get(0).toCharArray();
        for (int idx = 0; idx < line.length; ++idx) {
            if (line[idx] == '|') {
                return pos;
            }
            pos++;
        }
        return pos;
    }

    private char charAt(final int x, final int y) {
        if (y < 0 || y > this.input.size() - 1) {
            return ' ';
        }
        final String line = this.input.get(y);
        if (x < 0 || x > line.length() - 1) {
            return ' ';
        }
        return line.toCharArray()[x];
    }

    private char neighbor(final int x, final int y, final char dir) {
        switch (dir) {
            case 'u':
                return this.charAt(x, y - 1);
            case 'd':
                return this.charAt(x, y + 1);
            case 'l':
                return this.charAt(x - 1, y);
            case 'r':
                return this.charAt(x + 1, y);
            default:
                throw new IllegalStateException(String.format("At (%d, %d), dir = %c", x, y, dir));
        }
    }

    private char direction(final int x, final int y, final char dir, final char c) {
        switch (c) {
            case '+':
                if (dir == 'u' || dir == 'd') {
                    return this.horizontalTurn(x, y);
                } else {
                    return this.verticalTurn(x, y);
                }
            default:
                final char next = this.neighbor(x, y, dir);
                return next == ' ' ? ' ' : dir;
        }
    }

    private char horizontalTurn(final int x, final int y) {
        final char left = this.charAt(x - 1, y);
        if (left == ' ') {
            return 'r';
        } else {
            return 'l';
        }
    }

    private char verticalTurn(final int x, final int y) {
        final char down = this.charAt(x, y + 1);
        if (down == ' ') {
            return 'u';
        } else {
            return 'd';
        }
    }

}
