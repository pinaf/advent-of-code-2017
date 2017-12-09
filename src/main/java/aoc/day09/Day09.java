package aoc.day09;

import aoc.Challenge;
import aoc.StdInput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day09 implements Challenge<Long>  {

    private final char[] input;

    public Day09() {
        this(new StdInput(9).read());
    }

    public Day09(final String input) {
        this(input.toCharArray());
    }

    @Override
    public Long run() {
        boolean garbage = false;
        boolean ignore = false;
        long score = 0L;
        int currentScore = 0;
        for (int idx = 0; idx < this.input.length; ++idx) {
            final char current = this.input[idx];
            if (garbage) {
                if (ignore) {
                    ignore = false;
                } else {
                    if (current == '!') {
                        ignore = true;
                    } else if (current == '>') {
                        garbage = false;
                    }
                }
            } else {
                if (current == '<') {
                    garbage = true;
                }
                if (current == '{') {
                    currentScore += 1;
                    score += currentScore;
                } else if (current == '}') {
                    currentScore -= 1;
                }
            }
        }
        return score;
    }

}
