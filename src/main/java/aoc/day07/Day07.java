package aoc.day07;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import aoc.Challenge;
import aoc.StdInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public final class Day07<T> implements Challenge<T> {

    private static final String REGEX = "(?<name>([a-zA-Z])+) \\((?<weight>(\\d)+)\\)( -> )*(?<children>.*)";

    private final SolutionFunction<T> solution;

    private final ProgramInput[] programs;

    public Day07(final SolutionFunction<T> solution) {
        this(solution, new StdInput(7).read());
    }

    public Day07(final SolutionFunction<T> solution, final String input) {
        this(
            solution,
            Arrays.stream(input.split("\n"))
                .map(String::trim)
                .map(Day07::parse)
                .toArray(ProgramInput[]::new)
        );
    }

    Day07(final SolutionFunction<T> solution, final ProgramInput head, final ProgramInput... tail) {
        this(
            solution,
            Stream.concat(
                Stream.of(head),
                Arrays.stream(tail)
            ).toArray(ProgramInput[]::new)
        );
    }

    @Override
    public T run() {
        return this.solution.apply(this.findRoot());
    }

    private StructureNode findRoot() {
        final Map<String, ProgramInput> inputs = Arrays.stream(this.programs)
            .collect(Collectors.toMap(ProgramInput::name, Function.identity()));
        final Map<String, StructureNode> nodes = new HashMap<>(inputs.size());
        final Set<String> children = Arrays.stream(this.programs).map(ProgramInput::name).collect(Collectors.toSet());
        Optional<ProgramInput> next = Day07.next(inputs.values().stream(), nodes.keySet());
        while (next.isPresent()) {
            final ProgramInput current = next.get();
            current.children().forEach(children::remove);
            inputs.remove(current.name());
            nodes.put(current.name(), Day07.toNode(current, nodes));
            next = Day07.next(inputs.values().stream(), nodes.keySet());
        }
        assert inputs.isEmpty();
        assert nodes.size() == this.programs.length;
        assert children.size() == 1;
        return nodes.get(children.stream().findFirst().get());
    }

    private static Optional<ProgramInput> next(final Stream<ProgramInput> inputs, final Set<String> nodes) {
        return inputs
            .filter(input -> input.children().isEmpty() || input.children().stream().allMatch(nodes::contains))
            .findFirst();
    }

    private static StructureNode toNode(final ProgramInput info, final Map<String, StructureNode> nodes) {
        return new StructureNode.Default(
            new ProgramInfo.Default(info.name(), info.weight()),
            info.children().stream().map(nodes::get).collect(Collectors.toList())
        );
    }

    private static ProgramInput parse(final CharSequence input) {
        final Matcher matcher = Pattern.compile(Day07.REGEX).matcher(input);
        if (!matcher.find()) {
            throw new IllegalStateException("Bad Input data!");
        }
        final String children = matcher.group("children");
        final List<String> set;
        if (children.isEmpty()) {
            set = Collections.emptyList();
        } else {
            set = Arrays.stream(children.split(", ")).collect(Collectors.toList());
        }
        return new ProgramInput.Default(
            matcher.group("name"),
            Long.parseLong(matcher.group("weight")),
            set
        );
    }

}
