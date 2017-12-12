package aoc.day11;

public interface DistanceFunction {

    int get(int x, int y);

    final class StepCounting implements DistanceFunction {

        public int get(final int x, final int y) {
            if (x < 0) {
                return this.get(-x, -y);
            } else if (y < 0) {
                return this.get(x, x - y);
            } else {
                return this.countSteps(0, 0, x, y);
            }
        }

        private int countSteps(final int a, final int b, final int x, final int y) {
            if (a < x) {
                if (b < y) {
                    return 1 + this.countSteps(a + 1, b + 1, x, y);
                } else {
                    return x - a;
                }
            } else {
                return y - b;
            }
        }

    }

}
