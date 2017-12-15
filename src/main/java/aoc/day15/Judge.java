package aoc.day15;

import lombok.Getter;
import lombok.experimental.Accessors;

public interface Judge {

    long count();

    void compare(Generator left, Generator right);

    @Accessors(fluent = true)
    final class Lower16Bits implements Judge {

        @Getter
        private long count = 0L;

        @Override
        public void compare(final Generator left, final Generator right) {
            if ((left.next() & 0xffffL) == (right.next() & 0xffffL)) {
                this.count++;
            }
        }

    }

}
