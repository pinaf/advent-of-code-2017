package aoc.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import aoc.Challenge;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public final class Day12Common implements Challenge<Long> {

    private final Solution solution;

    private final Pipe[] input;

    Day12Common(final Solution solution, final String input) {
        this(
            solution,
            Arrays.stream(input.split("\n"))
                .map(Pipe.Default::new)
                .toArray(Pipe[]::new)
        );
    }

    @Override
    public Long run() {
        final List<Pipe> pipes = Arrays.stream(this.input).collect(Collectors.toList());
        final List<Group> groups = new ArrayList<>();
        while (!pipes.isEmpty()) {
            final Group group = new Group.Default();
            groups.add(group);
            final Pipe first = pipes.get(0);
            pipes.remove(first);
            group.add(first.left());
            group.add(first.right());
            Optional<Pipe> match = this.nextPipeInGroup(pipes, group);
            while (match.isPresent()) {
                final Pipe pipe = match.get();
                pipes.remove(pipe);
                group.add(pipe.right());
                match = this.nextPipeInGroup(pipes, group);
            }
        }
        return this.solution.apply(groups);
    }

    private Optional<Pipe> nextPipeInGroup(final Collection<Pipe> left, final Group group) {
        return left.stream()
            .filter(pipe -> group.containsAny(pipe.right()))
            .findFirst();
    }

}
