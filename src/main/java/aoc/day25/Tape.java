package aoc.day25;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

public interface Tape {

    void moveLeft();

    void moveRight();

    int head();

    int read();

    void write(int value);

    int checksum();

    @Slf4j
    @Accessors(fluent = true)
    final class Default implements Tape {

        private final List<Integer> positive;

        private final List<Integer> negative;

        @Getter
        private int head;

        private int max;

        public Default(final int size) {
            this.positive = new ArrayList<>(size);
            this.negative = new ArrayList<>(size);
            this.head = 0;
            this.max = 0;
            IntStream.range(0, size).forEach(n -> {
                this.positive.add(0);
                this.negative.add(0);
            });
        }

        @Override
        public void moveLeft() {
            this.head--;
            this.updateMax();
        }

        @Override
        public void moveRight() {
            this.head++;
            this.updateMax();
        }

        @Override
        public int read() {
            if (this.head >= 0) {
                return this.positive.get(this.head);
            } else {
                return this.negative.get(-this.head);
            }
        }

        @Override
        public void write(final int value) {
            //log.info("Writing {} at {}", value, this.head);
            if (this.head >= 0) {
                this.positive.set(this.head, value);
            } else {
                this.negative.set(-this.head, value);
            }
        }

        @Override
        public int checksum() {
            return IntStream.range(0, this.max + 1)
                .map(pos -> this.positive.get(pos) + this.negative.get(pos))
                .sum();
        }

        private void updateMax() {
            this.max = Math.max(this.max, Math.abs(this.head));
        }

    }

}
