package aoc.day25;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

public interface State {

    String key();

    Instruction instruction(int current);

    @Accessors(fluent = true)
    @RequiredArgsConstructor
    final class Default implements State {

        private static final Pattern PATTERN = Pattern.compile(
            "In state (?<key>([A-Z]+)):(\\s)+" +
            "If the current value is 0:(\\s)+" +
            "- Write the value (?<v0>(\\d)).(\\s)+" +
            "- Move one slot to the (?<d0>([a-z]+)).(\\s)+" +
            "- Continue with state (?<s0>([A-Z]+)).(\\s)+" +
            "If the current value is 1:(\\s)+" +
            "- Write the value (?<v1>(\\d)).(\\s)+" +
            "- Move one slot to the (?<d1>([a-z]+)).(\\s)+" +
            "- Continue with state (?<s1>([A-Z]+)).",
            Pattern.MULTILINE
        );

        @Getter
        private final String key;

        private final Instruction zero;

        private final Instruction one;

        @Override
        public Instruction instruction(final int current) {
            if (current == 0) {
                return this.zero;
            } else {
                return this.one;
            }
        }

        public static State parse(final CharSequence input) {
            final Matcher matcher = State.Default.PATTERN.matcher(input);
            matcher.find();
            return new State.Default(
                matcher.group("key"),
                new Instruction.Default(
                    Integer.parseInt(matcher.group("v0")),
                    State.Default.Move.valueOf(matcher.group("d0").toUpperCase(Locale.ENGLISH)).value(),
                    matcher.group("s0")
                ),
                new Instruction.Default(
                    Integer.parseInt(matcher.group("v1")),
                    State.Default.Move.valueOf(matcher.group("d1").toUpperCase(Locale.ENGLISH)).value(),
                    matcher.group("s1")
                )
            );
        }

        @Getter
        @Accessors(fluent = true)
        @RequiredArgsConstructor
        private enum Move {
            LEFT(-1),
            RIGHT(1);

            private final int value;
        }
    }

}
