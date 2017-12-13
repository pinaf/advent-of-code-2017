package aoc.day02;

import java.util.Arrays;
import java.util.regex.Pattern;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

public interface Row {

    int[] data();

    @Data
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    final class Default implements Row {

        private static final Pattern PATTERN = Pattern.compile("(\\s)+");

        private final int[] data;

        public Default(final CharSequence input) {
            this(
                Arrays.stream(Row.Default.PATTERN.split(input))
                    .mapToInt(Integer::parseUnsignedInt)
                    .toArray()
            );
        }

    }

}
