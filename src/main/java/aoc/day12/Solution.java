package aoc.day12;

import java.util.List;
import java.util.function.Function;

import lombok.RequiredArgsConstructor;

public interface Solution extends Function<List<Group>, Long> {

    @RequiredArgsConstructor
    final class GroupSize implements Solution {

        private final long program;

        @Override
        public Long apply(final List<Group> groups) {
            return groups.stream()
                .filter(group -> group.containsAny(this.program))
                .findFirst()
                .map(Group::size)
                .orElse(0L);
        }
    }

    final class NumberOfGroups implements Solution {
        @Override
        public Long apply(final List<Group> groups) {
            return (long) groups.size();
        }
    }

}
