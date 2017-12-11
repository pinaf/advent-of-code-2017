package aoc.day11;

import aoc.Challenge;
import aoc.StdInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day11 implements Challenge<Integer> {

    private final String[] input;

    public Day11() {
        this(new StdInput(11).read());
    }

    public Day11(final String input) {
        this(
            input.split(",")
        );
    }

    @Override
    public Integer run() {
        int x = 0;
        int y = 0;
        int max = 0;
        for (final String current : this.input) {
            switch (current) {
                case "n":
                    y += 1;
                    break;
                case "ne":
                    y += 1;
                    x += 1;
                    break;
                case "nw":
                    x -= 1;
                    break;
                case "s":
                    y -= 1;
                    break;
                case "se":
                    x += 1;
                    break;
                case "sw":
                    y -= 1;
                    x -= 1;
                    break;
            }
            final int distance = this.countStepsFromOrigin(x, y);
            if (distance > max) {
                max = distance;
            }
        }
        return max;
        //return this.countStepsFromOrigin(x, y);
    }

    private int countStepsFromOrigin(final int x, final int y) {
        if (x < 0) {
            return this.countStepsFromOrigin(-x, -y);
        } else if (y < 0) {
            return this.countStepsFromOrigin(x, x - y);
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
