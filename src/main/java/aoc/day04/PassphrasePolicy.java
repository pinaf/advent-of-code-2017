package aoc.day04;

import java.util.Collection;
import java.util.HashSet;

public interface PassphrasePolicy {

    boolean isValid(String[] passphrase);

    final class NoRepeatedWords implements PassphrasePolicy {
        @Override
        public boolean isValid(final String[] passphrase) {
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

}
