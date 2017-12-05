package aoc.day04;

import aoc.ChallengeWrap;

public final class Day04Part2 extends ChallengeWrap<Long> {

    private static final PassphrasePolicy POLICY = new PassphrasePolicy.NoAnagrams();

    public Day04Part2() {
        super(new Day04(Day04Part2.POLICY));
    }

    public Day04Part2(final String input) {
        super(new Day04(Day04Part2.POLICY, input));
    }

}
