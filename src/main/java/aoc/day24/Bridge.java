package aoc.day24;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

public interface Bridge {

    Bridge withComponent(Component component);

    int port();

    int length();

    long strength();

    @RequiredArgsConstructor
    final class Default implements Bridge {

        private final List<Component> components;

        public Default() {
            this.components = new ArrayList<>(100);
        }

        @Override
        public int port() {
            if (this.components.isEmpty()) {
                return 0;
            } else {
                return this.components.get(this.components.size() - 1).right();
            }
        }

        @Override
        public Bridge withComponent(final Component component) {
            if (component.left() == this.port()) {
                return this.appended(component);
            } else {
                return this.appended(component.flipped());
            }
        }

        @Override
        public int length() {
            return this.components.size();
        }

        @Override
        public long strength() {
            return this.components.stream().mapToLong(Component::strength).sum();
        }

        private Bridge appended(final Component component) {
            return new Bridge.Default(
                Stream.concat(
                    this.components.stream(),
                    Stream.of(component)
                ).collect(Collectors.toList())
            );
        }

    }

}
