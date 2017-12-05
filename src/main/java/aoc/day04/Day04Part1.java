package aoc.day04;

import aoc.ChallengeWrap;

public final class Day04Part1 extends ChallengeWrap<Long> {

    private static final PassphrasePolicy POLICY = new PassphrasePolicy.NoRepeatedWords();

    public Day04Part1() {
        super(new Day04(Day04Part1.POLICY));
    }

    public Day04Part1(final String input) {
        super(new Day04(Day04Part1.POLICY, input));
    }

}
