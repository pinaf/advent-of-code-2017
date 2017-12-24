package aoc.day24;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

public interface Component {

    int left();

    int right();

    Component flipped();

    boolean hasPortAvailable(int port);

    default int strength() {
        return this.left() + this.right();
    }

    @ToString
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    final class Default implements Component {

        @Getter
        private final int left;

        @Getter
        private final int right;

        public Default(final String input) {
            final String[] split = input.trim().split("/");
            this.left = Integer.parseInt(split[0]);
            this.right = Integer.parseInt(split[1]);
        }

        @Override
        public boolean hasPortAvailable(final int port) {
            return this.left == port || this.right == port;
        }

        @Override
        public Component flipped() {
            return new Component.Default(this.right, this.left);
        }

    }

}
