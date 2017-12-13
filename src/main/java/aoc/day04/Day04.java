package aoc.day04;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day04 implements TwoPartChallenge<Long, Long> {

    private final String input;

    public Day04() {
        this(new StdInput(4).read());
    }

    @Override
    public Long part1() {
        return new Day04Common(new PassphrasePolicy.NoRepeatedWords(), this.input).run();
    }

    @Override
    public Long part2() {
        return new Day04Common(new PassphrasePolicy.NoAnagrams(), this.input).run();
    }

}
