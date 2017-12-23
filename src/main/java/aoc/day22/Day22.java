package aoc.day22;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Day22 implements TwoPartChallenge<Long, Long> {

    private final Grid grid;

    private final int iter1;

    private final int iter2;

    public Day22() {
        this(new StdInput(22).read(), 10000, 10000000);
    }

    public Day22(final String input, final int iter) {
        this(new GridSimple(input), iter, iter);
    }

    public Day22(final String input, final int iter1, final int iter2) {
        this(new GridSimple(input), iter1, iter2);
    }

    public Day22(final Grid grid, final int iter1, final int iter2) {
        this.grid = new GridSmart(grid);
        this.iter1 = iter1;
        this.iter2 = iter2;
    }

    @Override
    public Long part1() {
        final Worm worm = new Worm.Simple(this.grid);
        for (int idx = 0; idx < this.iter1; ++idx) {
            worm.move();
        }
        //Day22.log.info(worm.toString());
        return worm.infections();
    }

    @Override
    public Long part2() {
        final Worm worm = new Worm.Smart(this.grid);
        for (int idx = 0; idx < this.iter2; ++idx) {
            worm.move();
        }
        //Day22.log.info(worm.toString());
        return worm.infections();
    }

}
