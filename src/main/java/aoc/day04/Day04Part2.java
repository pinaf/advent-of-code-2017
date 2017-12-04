package aoc.day04;

import aoc.Challenge;

public final class Day04Part2 implements Challenge<Long> {

    private static final PassphrasePolicy POLICY = new PassphrasePolicy.NoAnagrams();

    private final Challenge<Long> wrapped;

    public Day04Part2(final String... input) {
        this.wrapped = new Day04(Day04Part2.POLICY, input);
    }

    @Override
    public Long run() {
        return this.wrapped.run();
    }

}
