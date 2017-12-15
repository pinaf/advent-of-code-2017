package aoc;

import java.util.stream.Stream;

import aoc.day01.Day01;
import aoc.day02.Day02;
import aoc.day03.Day03;
import aoc.day04.Day04;
import aoc.day05.Day05;
import aoc.day06.Day06;
import aoc.day07.Day07;
import aoc.day08.Day08;
import aoc.day09.Day09;
import aoc.day10.Day10;
import aoc.day11.Day11;
import aoc.day12.Day12;
import aoc.day13.Day13;
import aoc.day14.Day14;
import aoc.day15.Day15;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("UtilityClass")
public final class Challenges {

    private Challenges() {
        // empty
    }

    public static void main(final String[] args) {
        Stream.of(
            new Day01(),
            new Day02(),
            new Day03(),
            new Day04(),
            new Day05(),
            new Day06(),
            new Day07(),
            new Day08(),
            new Day09(),
            new Day10(),
            new Day11(),
            new Day12(),
            new Day13(),
            new Day14(),
            new Day15()
        ).forEach(challenge -> {
            Challenges.log.info("{}: {}", challenge.name(), challenge.part1());
            Challenges.log.info("{}: {}", challenge.name(), challenge.part2());
        });
    }

}
