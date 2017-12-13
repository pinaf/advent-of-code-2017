package aoc.day13;

import aoc.Challenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day13Part2 implements Challenge<Long> {

    private final Day13 challenge;

    public Day13Part2() {
        this(new Day13(true));
    }

    public Day13Part2(final String input) {
        this(new Day13(true, input));
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
