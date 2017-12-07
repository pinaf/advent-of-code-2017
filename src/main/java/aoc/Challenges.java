package aoc;

import java.util.stream.Stream;

import aoc.day01.Day01Part1;
import aoc.day01.Day01Part2;
import aoc.day02.Day02Part1;
import aoc.day02.Day02Part2;
import aoc.day03.Day03Part1;
import aoc.day03.Day03Part2;
import aoc.day04.Day04Part1;
import aoc.day04.Day04Part2;
import aoc.day05.Day05Part1;
import aoc.day05.Day05Part2;
import aoc.day06.Day06Part1;
import aoc.day06.Day06Part2;
import aoc.day07.Day07Part1;
import aoc.day07.Day07Part2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("UtilityClass")
public final class Challenges {

    private Challenges() {
        // empty
    }

    public static void main(final String[] args) {
        Stream.of(
            new Day01Part1(),
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
            new Day07Part2()
        ).forEach(challenge -> Challenges.log.info("{}: {}", challenge.name(), challenge.run()));
    }

}
