package aoc.day09;

import lombok.Getter;
import lombok.experimental.Accessors;

public interface State {

    long score();

    long garbage();

    void newGroupSeen(int depth);

    void garbageSeen();

    @Getter
    @Accessors(fluent = true)
    final class Default implements State {

        private long score;

        private long garbage;

        @Override
        public void newGroupSeen(final int depth) {
            this.score += (long) depth;
        }

        @Override
        public void garbageSeen() {
            this.garbage++;
        }
    }

}
