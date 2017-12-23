package aoc.day22;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class GridXY implements Grid {

    private final Grid grid;

    @Override
    public int size() {
        return this.grid.size();
    }

    @Override
    public void set(final int x, final int y, final int v) {
        final int r = this.rowFromY(y);
        final int c = this.colFromX(x);
        this.grid.set(r, c, v);
    }

    @Override
    public int get(final int x, final int y) {
        final int r = this.rowFromY(y);
        final int c = this.colFromX(x);
        return this.grid.get(r , c);
    }

    @Override
    public String asString() {
        return this.grid.asString();
    }

    @Override
    public String toString() {
        return this.grid.toString();
    }

    @Override
    public String printRow(final int row) {
        return this.grid.printRow(row);
    }

    private int colFromX(final int x) {
        return (this.size() - 1) / 2 + x;
    }

    private int rowFromY(final int y) {
        return (this.size() - 1) / 2 - y;
    }

}
