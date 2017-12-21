package aoc.day21;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public final class Day21 implements TwoPartChallenge<Long, Long> {

    private final Pattern initial = new Pattern.Default(".#.\n..#\n###");

    private final int iterations;

    private final Rule[] rules;

    public Day21(final int iterations) {
        this(iterations, new StdInput(21).read());
    }

    public Day21(final int iterations, final String input) {
        this(
            iterations,
            Arrays.stream(input.split("\n"))
                .map(Rule.Default::new)
                .toArray(Rule[]::new)
        );
    }

    @Override
    public Long part1() {
        log.info("Initial: \n{}", this.initial);
        Pattern current = this.initial;
        for (int iteration = 0; iteration < this.iterations; ++iteration) {
            final List<Pattern> split = current.split().stream()
                .map(this::transform)
                .peek(p -> log.info("Split Transformed: \n{}", p))
                .collect(Collectors.toList());
            current = new Pattern.Composite(split);
            log.info("Current: \n{}", current);
        }
        return current.pixelsOn();
    }

    @Override
    public Long part2() {
        return this.part1();
    }

    private Pattern transform(final Pattern pattern) {
        return this.matchingRule(pattern).apply(pattern);
    }

    private Rule matchingRule(final Pattern pattern) {
        return Arrays.stream(this.rules).filter(rule -> rule.matches(pattern)).findFirst().orElseThrow(
            () -> new IllegalStateException(String.format("Unable to find rule matching pattern\n%s", pattern))
        );
    }

}
