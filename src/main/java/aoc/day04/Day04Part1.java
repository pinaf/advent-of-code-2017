package aoc.day04;

import aoc.Challenge;

public final class Day04Part1 implements Challenge<Long> {

    private static final PassphrasePolicy POLICY = new PassphrasePolicy.NoRepeatedWords();

    private final Challenge<Long> wrapped;

    public Day04Part1(final String... input) {
        this.wrapped = new Day04(Day04Part1.POLICY, input);
    }

    @Override
    public Long run() {
        return this.wrapped.run();
    }

}
