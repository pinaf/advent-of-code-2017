package aoc.day21;

import java.util.function.Function;
import java.util.stream.Stream;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

public interface Rule {

    boolean matches(Pattern pattern);

    Pattern apply(Pattern pattern);

    @Slf4j
    @Getter
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    final class Default implements Rule {

        private final Pattern from;

        private final Pattern to;

        public Default(final String input) {
            final String[] split = input.split(" => ");
            this.from = new Pattern.Default(split[0], "/");
            //log.info("Variations for\n{}", pattern);
            //this.from.forEach(p -> log.info("Variation\n{}", p));
            this.to = new Pattern.Default(split[1], "/");
        }

        @Override
        public boolean matches(final Pattern pattern) {
            return Rule.Default.variations().anyMatch(v -> v.apply(pattern).eq(this.from));
        }

        @Override
        public Pattern apply(final Pattern pattern) {
            return this.to;
        }

        private static Stream<Function<Pattern, Pattern>> variations() {
            return Stream.of(
                Function.identity(),
                Pattern.FlippedHorizontal::new,
                Pattern.FlippedVertical::new,
                Pattern.Rotated::new,
                p -> new Pattern.FlippedHorizontal(new Pattern.Rotated(p)),
                p -> new Pattern.FlippedVertical(new Pattern.Rotated(p)),
                pattern -> new Pattern.Rotated(new Pattern.Rotated(pattern)),
                pattern -> new Pattern.Rotated(new Pattern.Rotated(new Pattern.Rotated(pattern)))
            );
        }

    }

}
