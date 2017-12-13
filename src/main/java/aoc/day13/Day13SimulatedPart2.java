package aoc.day13;

import aoc.Challenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day13SimulatedPart2 implements Challenge<Long> {

    private final Day13Simulated challenge;

    public Day13SimulatedPart2() {
        this(new Day13Simulated(true));
    }

    public Day13SimulatedPart2(final String input) {
        this(new Day13Simulated(true, input));
    }

    @Override
    public Long run() {
        long delay = 0L;
        while (!this.challenge.run().isEmpty()) {
            delay++;
            this.challenge.resetAnddelay(delay);
        }
        return delay;
    }

}
