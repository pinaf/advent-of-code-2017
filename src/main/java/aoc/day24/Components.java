package aoc.day24;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

public interface Components {

    boolean isEmpty();

    Stream<Component> stream();

    Components without(Component component);

    Components matches(int port);

    @RequiredArgsConstructor
    final class Default implements Components {

        private final Collection<Component> components;

        public Default(final String input) {
            this(
                Arrays.stream(input.split("\n"))
                    .map(Component.Default::new)
                    .collect(Collectors.toList())
            );
        }

        @Override
        public boolean isEmpty() {
            return this.components.isEmpty();
        }

        @Override
        public Stream<Component> stream() {
            return this.components.stream();
        }

        @Override
        public Components without(final Component component) {
            final Collection<Component> remaining = new LinkedList<>(this.components);
            remaining.remove(component);
            return new Components.Default(remaining);
        }

        @Override
        public Components matches(final int port) {
            return new Components.Default(
                this.stream()
                    .filter(comp -> comp.hasPortAvailable(port))
                    .collect(Collectors.toSet())
            );
        }

    }

}
