package aoc.day04;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public interface PassphrasePolicy {

    boolean isValid(String[] passphrase);

    final class NoAnagrams implements PassphrasePolicy {
        @Override
        public boolean isValid(final String[] passphrase) {
            final Collection<String> prohibited = new HashSet<>(passphrase.length);
            return Arrays.stream(passphrase)
                .map(word -> {
                    final char[] array = word.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                }).allMatch(word -> {
                    final boolean valid = !prohibited.contains(word);
                    prohibited.add(word);
                    return valid;
                });
        }
    }

    final class NoRepeatedWords implements PassphrasePolicy {
        @Override
        public boolean isValid(final String[] passphrase) {
            final Collection<String> prohibited = new HashSet<>(passphrase.length);
            return Arrays.stream(passphrase).allMatch(word -> {
                final boolean valid = !prohibited.contains(word);
                prohibited.add(word);
                return valid;
            });
        }
    }

}
