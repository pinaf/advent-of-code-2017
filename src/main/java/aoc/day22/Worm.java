package aoc.day22;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

public interface Worm {

    void move();

    long infections();

    @Getter
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    enum Direction {

        UP(0, 1),
        DOWN(0, -1),
        LEFT(-1, 0),
        RIGHT(1, 0);

        private final int dx;

        private final int dy;

    }

    @Slf4j
    @Accessors(fluent = true)
    final class Simple implements Worm {

        private final Worm.Direction[] directions = {
            Worm.Direction.UP,
            Worm.Direction.RIGHT,
            Worm.Direction.DOWN,
            Worm.Direction.LEFT
        };

        private final Grid grid;

        private int x;

        private int y;

        private int d;

        @Getter
        private long infections;

        public Simple(final Grid grid) {
            this.grid = grid;
            this.init();
        }

        @Override
        public void move() {
            this.d = this.burst();
            final Worm.Direction dir = this.directions[this.d];
            this.x += dir.dx();
            this.y += dir.dy();
            //log.info("{} ({},{})\n{}", dir.name(), this.x, this.y, this.grid);
        }

        @Override
        public String toString() {
            final Worm.Direction dir = this.directions[this.d];
            return String.format("%s (%d,%d)\n%s", dir.name(), this.x, this.y, this.grid);
        }

        private void init() {
            this.x = 0;
            this.y = 0;
            this.infections = 0L;
            //Worm.Simple.log.info("({},{}) {}\n{}", this.x, this.y, "UP", this.grid);
        }

        private int burst() {
            final int current = this.grid.get(this.x, this.y);
            final int dir;
            if (current == Grid.CLEAN) {
                dir = this.turnLeft();
                this.infect();
            } else {
                dir = this.turnRight();
                this.clean();
            }
            return dir;
        }

        private int turnLeft() {
            return (this.d + 3) % this.directions.length;
        }

        private int turnRight() {
            return (this.d + 1) % this.directions.length;
        }

        private void clean() {
            this.grid.set(this.x, this.y, Grid.CLEAN);
        }

        private void infect() {
            this.grid.set(this.x, this.y, Grid.INFECTED);
            this.infections++;
        }

    }

    @Slf4j
    @Accessors(fluent = true)
    final class Smart implements Worm {

        private final Worm.Direction[] directions = {
            Worm.Direction.UP,
            Worm.Direction.RIGHT,
            Worm.Direction.DOWN,
            Worm.Direction.LEFT
        };

        private final Grid grid;

        private int x;

        private int y;

        private int d;

        @Getter
        private long infections;

        public Smart(final Grid grid) {
            this.grid = grid;
            this.init();
        }

        @Override
        public void move() {
            this.d = this.burst();
            final Worm.Direction dir = this.directions[this.d];
            this.x += dir.dx();
            this.y += dir.dy();
            //log.info("{} ({},{})\n{}", dir.name(), x, y, this.grid);
        }

        @Override
        public String toString() {
            final Worm.Direction dir = this.directions[this.d];
            return String.format("%s (%d,%d)\n%s", dir.name(), this.x, this.y, this.grid);
        }

        private void init() {
            this.x = 0;
            this.y = 0;
            this.d = 0;
            this.infections = 0L;
            //Worm.Simple.log.info("({},{}) {}\n{}", this.x, this.y, "UP", this.grid);
        }

        private int burst() {
            final int current = this.grid.get(this.x, this.y);
            int dir = this.d;
            if (current == Grid.CLEAN) {
                dir = this.turnLeft();
                this.weaken();
            } else if (current == Grid.WEAKENED) {
                dir = this.d;
                this.infect();
            } else if (current == Grid.INFECTED) {
                dir = this.turnRight();
                this.flag();
            } else if (current == Grid.FLAGGED) {
                dir = this.turnBack();
                this.clean();
            }
            return dir;
        }

        private int turnLeft() {
            return (this.d + 3) % this.directions.length;
        }

        private int turnRight() {
            return (this.d + 1) % this.directions.length;
        }

        private int turnBack() {
            return (this.d + 2) % this.directions.length;
        }

        private void clean() {
            this.grid.set(this.x, this.y, Grid.CLEAN);
        }

        private void weaken() {
            this.grid.set(this.x, this.y, Grid.WEAKENED);
        }

        private void infect() {
            this.grid.set(this.x, this.y, Grid.INFECTED);
            this.infections++;
        }

        private void flag() {
            this.grid.set(this.x, this.y, Grid.FLAGGED);
        }

    }

}
