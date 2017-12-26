package aoc.day25;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day25 implements TwoPartChallenge<Integer, Integer> {

    private final int steps;

    private final TuringMachine machine;

    public Day25() {
        this(new StdInput(25).read());
    }

    public Day25(final String input) {
        this(
            Day25.parseSteps(input),
            new TuringMachine.Default(input)
        );
    }

    public Day25(final String state, final int steps, final State... states) {
        this(steps, new TuringMachine.Default(state, states));
    }

    @Override
    public Integer part1() {
        this.machine.run(this.steps);
        return this.machine.checksum();
    }

    @Override
    public Integer part2() {
        return 0;
    }

    private static int parseSteps(final String input) {
        final String first = input.split("\n\n")[0];
        final Matcher matcher = Pattern.compile("Perform a diagnostic checksum after (?<steps>(\\d+)) steps.").matcher(first);
        matcher.find();
        return Integer.parseInt(matcher.group("steps"));
    }

}
