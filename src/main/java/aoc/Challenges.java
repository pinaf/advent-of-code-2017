package aoc;

import java.util.stream.Stream;

import aoc.day13.Day13;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("UtilityClass")
public final class Challenges {

    private Challenges() {
        // empty
    }

    public static void main(final String[] args) {
        Stream.of(
            /*new Day01Part1(),
            new Day01Part2(),
            new Day02Part1(),
            new Day02Part2(),
            new Day03Part1(),
            new Day03Part2(),
            new Day04Part1(),
            new Day04Part2(),
            new Day05Part1(),
            new Day05Part2(),
            new Day06Part1(),
            new Day06Part2(),
            new Day07Part1(),
            new Day07Part2(),
            new Day08Part1(),
            new Day08Part2(),
            new Day09Part1(),
            new Day09Part2(),
            new Day10Part1(),
            new Day10Part2(),
            new Day11Part1(),
            new Day11Part2(),
            new Day12Part1(),
            new Day12Part2(),
            */new Day13()
        ).forEach(challenge -> Challenges.log.info("{}: {}", challenge.name(), challenge.run()));
    }

}
