package aoc.day22;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Day22 implements TwoPartChallenge<Long, Long> {

    private final Grid grid;

    public Day22() {
        this(new StdInput(22).read());
    }

    public Day22(final String input) {
        this(new GridSimple(input));
    }

    public Day22(final Grid grid) {
        final int delta = 540;
        final int size = grid.size();
        this.grid = new GridSimple(size + delta);
        final int half = (this.grid.size() - 1) / 2;
        final int h = (size - 1) / 2;
        for (int r = 0; r < size; ++r) {
            for (int c = 0; c < size; ++c) {
                this.grid.set(half - h + r, half - h + c, grid.get(r, c));
            }
        }
    }

    @Override
    public Long part1() {
        final Worm worm = new Worm.Simple(this.grid);
        for (int idx = 0; idx < 10000; ++idx) {
            worm.move();
        }
        //Day22.log.info("({},{})\n{}", r, c, this.grid);
        return worm.infections();
    }

    @Override
    public Long part2() {
        final Worm worm = new Worm.Smart(this.grid);
        for (int idx = 0; idx < 10000000; ++idx) {
            worm.move();
        }
        //Day22.log.info("({},{})\n{}", r, c, this.grid);
        return worm.infections();
    }

}
