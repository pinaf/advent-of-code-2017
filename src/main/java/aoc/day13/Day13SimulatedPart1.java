package aoc.day13;

import java.util.List;

import aoc.Challenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day13SimulatedPart1 implements Challenge<Long> {

    private final Challenge<List<Layer>> challenge;

    public Day13SimulatedPart1() {
        this(new Day13Simulated(false));
    }

    public Day13SimulatedPart1(final String input) {
        this(new Day13Simulated(false, input));
    }

    @Override
    public Long run() {
        return this.challenge.run().stream().mapToLong(Layer::severity).sum();
    }

}
