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
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);

        private final int dr;
        private final int dc;
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

        private int r;

        private int c;

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
            this.c += dir.dc();
            this.r += dir.dr();
            //log.info("{} ({},{})\n{}", dir.name(), r, c, this.grid);
        }

        private void init() {
            final int size = this.grid.size();
            this.c = (size - 1) / 2;
            this.r = (size - 1) / 2;
            this.infections = 0L;
            Worm.Simple.log.info("({},{}) {}\n{}", this.r, this.c, "UP", this.grid);
        }

        private int burst() {
            final int current = this.grid.get(this.r, this.c);
            int dir;
            if (current == Grid.CLEAN) {
                dir = this.turnLeft();
                if (dir < 0) {
                    dir += this.directions.length;
                }
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
            this.grid.set(this.r, this.c, Grid.CLEAN);
        }

        private void infect() {
            this.grid.set(this.r, this.c, Grid.INFECTED);
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

        private int r;

        private int c;

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
            this.c += dir.dc();
            this.r += dir.dr();
            //log.info("{} ({},{})\n{}", dir.name(), r, c, this.grid);
        }

        private void init() {
            final int size = this.grid.size();
            this.c = (size - 1) / 2;
            this.r = (size - 1) / 2;
            this.d = 0;
            this.infections = 0L;
            Worm.Simple.log.info("({},{}) {}\n{}", this.r, this.c, "UP", this.grid);
        }

        private int burst() {
            final int current = this.grid.get(this.r, this.c);
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
            this.grid.set(this.r, this.c, Grid.CLEAN);
        }

        private void weaken() {
            this.grid.set(this.r, this.c, Grid.WEAKENED);
        }

        private void infect() {
            this.grid.set(this.r, this.c, Grid.INFECTED);
            this.infections++;
        }

        private void flag() {
            this.grid.set(this.r, this.c, Grid.FLAGGED);
        }

    }

}
