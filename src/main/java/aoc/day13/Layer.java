package aoc.day13;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

public interface Layer {

    int depth();

    int range();

    void tick();

    void tick(long time);

    int scanner();

    void reset();

    @Data
    @Accessors(fluent = true)
    @ToString
    final class Default implements Layer {

        private final int depth;

        private final int range;

        private int direction = 1;

        private int scanner = 0;

        public Default(final String input) {
            final String[] split = input.split(": ");
            this.depth = Integer.parseInt(split[0]);
            this.range = Integer.parseInt(split[1]);
        }

        @Override
        public void tick() {
            if (this.scanner == 0 && this.direction == -1) {
                this.direction = 1;
            } else if (this.scanner == this.range - 1 && this.direction == 1) {
                this.direction = -1;
            }
            this.scanner += this.direction;
        }

        @Override
        public void tick(final long time) {
            final long cycle = (long) this.cycle();
            if (time >= cycle) {
                this.tick(time % cycle);
            } else {
                for (long idx = 0L; idx < time; ++idx) {
                    this.tick();
                }
            }
        }

        @Override
        public void reset() {
            this.scanner = 0;
            this.direction = 1;
        }

        private int cycle() {
            return 2 * (this.range - 1);
        }

    }

}
