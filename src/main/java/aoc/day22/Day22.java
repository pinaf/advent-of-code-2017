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
        this.grid = new GridSmart(grid);
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
