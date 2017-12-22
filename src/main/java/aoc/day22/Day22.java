package aoc.day22;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Day22 implements TwoPartChallenge<Long, Long> {

    private final Pattern full;

    private final Day22.Direction[] directions = {
        Day22.Direction.UP, Day22.Direction.RIGHT, Day22.Direction.DOWN, Day22.Direction.LEFT
    };

    private long infections;

    public Day22() {
        this(new StdInput(22).read());
    }

    public Day22(final String input) {
        this(new Pattern.Default(input));
    }

    public Day22(final Pattern pattern) {
        final int delta = 540;
        final int size = pattern.size();
        this.full = new Pattern.Default(size + delta);
        final int half = (this.full.size() - 1) / 2;
        final int h = (size - 1) / 2;
        for (int r = 0; r < size; ++r) {
            for (int c = 0; c < size; ++c) {
                if (pattern.on(r, c) != 0) {
                    //this.full.set(half - h + r, half - h + c, 1);
                    this.full.set(half - h + r, half - h + c, 2);
                }
            }
        }
    }

    @Override
    public Long part1() {
        final int size = this.full.size();
        int c = (size - 1) / 2;
        int r = (size - 1) / 2;
        int d = 0;
        Day22.log.info("({},{}) {}\n{}", r, c, "UP", this.full);
        for (int idx = 0; idx < 10000; ++idx) {
            d = this.burst1(c, r, d);
            final Day22.Direction dir = this.directions[d];
            c += dir.dc();
            r += dir.dr();
            //log.info("{} ({},{})\n{}", dir.name(), r, c, this.full);
        }
        Day22.log.info("({},{})\n{}", r, c, this.full);
        return this.infections;
    }

    @Override
    public Long part2() {
        final int size = this.full.size();
        int c = (size - 1) / 2;
        int r = (size - 1) / 2;
        int d = 0;
        Day22.log.info("({},{}) {}\n{}", r, c, "UP", this.full);
        for (int idx = 0; idx < 10000000; ++idx) {
            d = this.burst2(c, r, d);
            final Day22.Direction dir = this.directions[d];
            c += dir.dc();
            r += dir.dr();
            //log.info("{} ({},{})\n{}", dir.name(), r, c, this.full);
        }
        Day22.log.info("({},{})\n{}", r, c, this.full);
        return this.infections;
    }

    private int burst1(final int c, final int r, final int d) {
        final int current = this.full.on(r, c);
        int dir;
        if (current == 0) {
            dir = (d - 1) % this.directions.length;
            if (dir < 0) {
                dir += this.directions.length;
            }
            this.infections++;
        } else {
            dir = (d + 1) % this.directions.length;
        }
        this.full.flip(r, c);
        return dir;
    }

    private int burst2(final int c, final int r, final int d) {
        final int current = this.full.on(r, c);
        int dir = d;
        if (current == 0) {
            dir = (d + 3) % this.directions.length;
        } else if (current == 1) {
            dir = d;
            this.infections++;
        } else if (current == 2) {
            dir = (d + 1) % this.directions.length;
        } else if (current == 3) {
            dir = (d + 2) % this.directions.length;
        }
        this.full.incMod4(r, c);
        return dir;
    }

    @Getter
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    enum Direction {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);

        private final int dr;
        private final int dc;
    }

}
