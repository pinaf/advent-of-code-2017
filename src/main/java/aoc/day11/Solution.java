package aoc.day11;

public interface Solution {

    void updateDistance(int distance);

    int get();

    final class FinalDistance implements Solution {

        private int distance = 0;

        @Override
        public void updateDistance(final int distance) {
            this.distance = distance;
        }

        @Override
        public int get() {
            return this.distance;
        }
    }

    final class GreatestDistance implements Solution {

        private int distance = 0;

        @Override
        public void updateDistance(final int distance) {
            if (distance > this.distance) {
                this.distance = distance;
            }
        }

        @Override
        public int get() {
            return this.distance;
        }
    }

}
