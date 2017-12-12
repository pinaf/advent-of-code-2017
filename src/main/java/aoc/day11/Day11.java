package aoc.day11;

import aoc.Challenge;
import aoc.StdInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day11 implements Challenge<Integer> {

    private final DistanceFunction distance = new DistanceFunction.StepCounting();

    private final Solution solution;

    private final String[] input;

    Day11(final Solution solution) {
        this(solution, new StdInput(11).read());
    }

    Day11(final Solution solution, final String input) {
        this(
            solution,
            input.split(",")
        );
    }

    @Override
    public Integer run() {
        int x = 0;
        int y = 0;
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
            this.solution.updateDistance(this.distance.get(x, y));
        }
        return this.solution.get();
    }

}
