package aoc.day24;

import aoc.StdInput;
import aoc.TwoPartChallenge;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Day24 implements TwoPartChallenge<Long, Long> {

    private final Components components;

    public Day24() {
        this(new StdInput(24).read());
    }

    public Day24(final String input) {
        this(new Components.Default(input));
    }

    @Override
    public Long part1() {
        return this.bestBridgeStrength(new Bridge.Default(), this.components);
    }

    @Override
    public Long part2() {
        return this.longestBridges(new Bridge.Default(), this.components)
            .stream()
            .mapToLong(Bridge::strength)
            .max().orElse(0L);
    }

    private long bestBridgeStrength(final Bridge bridge, final Components available) {
        final Components matches = available.matches(bridge.port());
        if (matches.isEmpty()) {
            return bridge.strength();
        }
        return matches.stream().mapToLong(
            comp -> this.bestBridgeStrength(
                bridge.withComponent(comp),
                available.without(comp)
            )
        ).max().orElse(0L);
    }

    private Collection<Bridge> longestBridges(final Bridge bridge, final Components available) {
        final Components matches = available.matches(bridge.port());
        if (matches.isEmpty()) {
            return Collections.singleton(bridge);
        }
        final List<Bridge> bridges = matches.stream().flatMap(
            comp -> this.longestBridges(
                bridge.withComponent(comp),
                available.without(comp)
            ).stream()
        ).collect(Collectors.toList());
        final int max = bridges.stream().mapToInt(Bridge::length).max().orElse(0);
        return bridges.stream()
            .filter(br -> br.length() == max)
            .collect(Collectors.toList());
    }

}
