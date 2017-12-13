package aoc.day04;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import aoc.Challenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day04Common implements Challenge<Long> {

    private static final Pattern PATTERN = Pattern.compile("(\\s)+");

    private final PassphrasePolicy policy;

    private final List<String[]> passphrases;

    Day04Common(final PassphrasePolicy policy, final String input) {
        this(policy, Arrays.stream(input.split("\n")));
    }

    Day04Common(final PassphrasePolicy policy, final Stream<String> passphrases) {
        this(
            policy,
            passphrases
                .map(Day04Common.PATTERN::split)
                .collect(Collectors.toList())
        );
    }

    @Override
    public Long run() {
        return this.passphrases.stream()
            .filter(this.policy::isValid)
            .count();
    }

}
