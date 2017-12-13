package aoc.day13;

import java.util.List;

import aoc.Challenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day13Part1 implements Challenge<Long> {

    private final Challenge<List<Layer>> challenge;

    public Day13Part1() {
        this(new Day13(false));
    }

    public Day13Part1(final String input) {
        this(new Day13(false, input));
    }

    @Override
    public Long run() {
        return this.challenge.run().stream().mapToLong(Layer::severity).sum();
    }

}
