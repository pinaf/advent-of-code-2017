package aoc.day12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import aoc.Challenge;
import aoc.StdInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public final class Day12 implements Challenge<Long> {

    private final Pipe[] input;

    public Day12() {
        this(new StdInput(12).read());
    }

    public Day12(final String input) {
        this(
            Arrays.stream(input.split("\n"))
                .map(Day12::parse)
                .toArray(Pipe[]::new)
        );
    }

    @Override
    public Long run() {
        final Set<Long> set = new HashSet<>(0);
        //set.add(0L);
        final List<Pipe> left = Arrays.stream(this.input).collect(Collectors.toList());
        long groups = 0L;
        while (!left.isEmpty()) {
            final Pipe first = left.get(0);
            left.remove(first);
            set.add(first.left());
            Arrays.stream(first.right()).forEach(set::add);
            log.info("processing {}", first.left());
            Optional<Pipe> pipe = this.select(left, set);
            while (pipe.isPresent()) {
                left.remove(pipe.get());
                Arrays.stream(pipe.get().right()).forEach(set::add);
                pipe = this.select(left, set);
            }
            set.clear();
            groups++;
        }
        return groups;
        //return (long) set.size();
    }

    private Optional<Pipe> select(final List<Pipe> left, final Set<Long> neighbors) {
        return left.stream()
            .filter(pipe -> Arrays.stream(pipe.right()).anyMatch(neighbors::contains))
            .findFirst();
    }


    private static Pipe parse(final String input) {
        final String[] splt = input.split(" <-> ");
        return new Pipe.Default(
            Long.parseLong(splt[0]),
            Arrays.stream(splt[1].trim().split(", ")).mapToLong(Long::parseLong).toArray()
        );
    }

}
