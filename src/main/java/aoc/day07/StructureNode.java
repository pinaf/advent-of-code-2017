package aoc.day07;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

public interface StructureNode {

    ProgramInfo program();

    List<StructureNode> children();

    long weight();

    boolean balanced();

    @Getter
    @Accessors(fluent = true)
    @RequiredArgsConstructor
    @EqualsAndHashCode
    @ToString
    final class Default implements StructureNode {

        private final ProgramInfo program;

        private final List<StructureNode> children;

        public Default(final ProgramInfo program) {
            this(program, Collections.emptyList());
        }

        public Default(final ProgramInfo program, final StructureNode... children) {
            this(program, Arrays.stream(children).collect(Collectors.toList()));
        }

        @Override
        public long weight() {
            final long value = this.children.stream().mapToLong(StructureNode::weight).sum();
            return value + this.program.weight();
        }

        @Override
        public boolean balanced() {
            return this.children.stream().mapToLong(StructureNode::weight).distinct().count() <= 1L;
        }

    }

}
