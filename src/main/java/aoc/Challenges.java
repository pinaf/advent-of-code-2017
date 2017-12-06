package aoc;

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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("UtilityClass")
public final class Challenges {

    private Challenges() {
        // empty
    }

    public static void main(final String[] args) {
        Challenges.log.info("Day 01 - Part 1: {}", new Day01Part1().run());
        Challenges.log.info("Day 01 - Part 2: {}", new Day01Part2().run());
        Challenges.log.info("Day 02 - Part 1: {}", new Day02Part1().run());
        Challenges.log.info("Day 02 - Part 2: {}", new Day02Part2().run());
        Challenges.log.info("Day 03 - Part 1: {}", new Day03Part1().run());
        Challenges.log.info("Day 03 - Part 2: {}", new Day03Part2().run());
        Challenges.log.info("Day 04 - Part 1: {}", new Day04Part1().run());
        Challenges.log.info("Day 04 - Part 2: {}", new Day04Part2().run());
        Challenges.log.info("Day 05 - Part 1: {}", new Day05Part1().run());
        Challenges.log.info("Day 05 - Part 2: {}", new Day05Part2().run());
        Challenges.log.info("Day 06 - Part 1: {}", new Day06Part1().run());
    }

}
