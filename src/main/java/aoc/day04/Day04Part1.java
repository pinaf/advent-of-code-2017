package aoc.day04;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import aoc.Challenge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day04Part1 implements Challenge<Long> {

    private static final Pattern PATTERN = Pattern.compile("(\\s)+");

    private final List<String[]> passphrases;

    public Day04Part1(final String... input) {
        this(Arrays.stream(input));
    }

    public Day04Part1(final Stream<String> passphrases) {
        this(
            passphrases
                .map(Day04Part1.PATTERN::split)
                .collect(Collectors.toList())
        );
    }

    @Override
    public Long run() {
        return this.passphrases.stream()
            .filter(Day04Part1::isValidPassphrase)
            .count();
    }

    private static boolean isValidPassphrase(final String[] passphrase) {
        final Collection<String> words = new HashSet<>(passphrase.length);
        for (final String word : passphrase) {
            if (words.contains(word)) {
                return false;
            } else {
                words.add(word);
            }
        }
        return true;
    }

}
