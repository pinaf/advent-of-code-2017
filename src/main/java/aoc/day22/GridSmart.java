package aoc.day22;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class GridSmart implements Grid {

    private Grid grid;

    public GridSmart(final Grid grid) {
        this.grid = new GridXY(grid);
    }

    @Override
    public int size() {
        return this.grid.size();
    }

    @Override
    public void set(final int x, final int y, final int v) {
        this.ensureSize(x, y);
        this.grid.set(x, y, v);
    }

    @Override
    public int get(final int x, final int y) {
        this.ensureSize(x, y);
        return this.grid.get(x, y);
    }

    @Override
    public String toString() {
        return this.grid.toString();
    }

    private void ensureSize(final int x, final int y) {
        while (this.outOfBounds(x, y)) {
            this.rescale();
        }
    }

    private boolean outOfBounds(final int x, final int y) {
        return Math.max(Math.abs(x), Math.abs(y)) > (this.size() - 1) / 2;
    }

    private void rescale() {
        final Grid old = this.grid;
        final int current = old.size();
        final int target = 2 * current + 1;
        log.info("Re-scaling grid from {} to {}", current, target);
        this.grid = new GridXY(new GridSimple(target));
        final int h = (current - 1) / 2;
        for (int x = -h; x <= h; ++x) {
            for (int y = -h; y <= h; ++y) {
                this.grid.set(x, y, old.get(x, y));
            }
        }
    }

}
