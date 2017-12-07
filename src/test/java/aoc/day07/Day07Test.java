package aoc.day07;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public final class Day07Test {

    private static final String INPUT = "pbga (66)\n" +
        "xhth (57)\n" +
        "ebii (61)\n" +
        "havc (66)\n" +
        "ktlj (57)\n" +
        "fwft (72) -> ktlj, cntj, xhth\n" +
        "qoyq (66)\n" +
        "padx (45) -> pbga, havc, qoyq\n" +
        "tknk (41) -> ugml, padx, fwft\n" +
        "jptl (61)\n" +
        "ugml (68) -> gyxo, ebii, jptl\n" +
        "gyxo (61)\n" +
        "cntj (57)";

    private final StructureNode structure = new StructureNode.Default(
        new ProgramInfo.Default("tknk", 41L),
        new StructureNode.Default(
            new ProgramInfo.Default("ugml", 68L),
            new StructureNode.Default(new ProgramInfo.Default("gyxo", 61L)),
            new StructureNode.Default(new ProgramInfo.Default("ebii", 61L)),
            new StructureNode.Default(new ProgramInfo.Default("jptl", 61L))
        ),
        new StructureNode.Default(
            new ProgramInfo.Default("padx", 45L),
            new StructureNode.Default(new ProgramInfo.Default("pbga", 66L)),
            new StructureNode.Default(new ProgramInfo.Default("havc", 66L)),
            new StructureNode.Default(new ProgramInfo.Default("qoyq", 66L))
        ),
        new StructureNode.Default(
            new ProgramInfo.Default("fwft", 72L),
            new StructureNode.Default(new ProgramInfo.Default("ktlj", 57L)),
            new StructureNode.Default(new ProgramInfo.Default("cntj", 57L)),
            new StructureNode.Default(new ProgramInfo.Default("xhth", 57L))
        )
    );

    @Test
    public void part1() {
        MatcherAssert.assertThat(new Day07Part1(Day07Test.INPUT).run(), Matchers.is("tknk"));
        MatcherAssert.assertThat(new Day07Part1().run(), Matchers.is("eugwuhl"));
        MatcherAssert.assertThat(new Day07<>(node -> node, Day07Test.INPUT).run(), Matchers.is(this.structure));
    }

    @Test
    public void part2() {
        MatcherAssert.assertThat(new Day07Part2(Day07Test.INPUT).run(), Matchers.is(60L));
        MatcherAssert.assertThat(new Day07Part2().run(), Matchers.is(420L));
    }

}
