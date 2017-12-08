package aoc.day08;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import aoc.Challenge;
import aoc.StdInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public final class Day08 implements Challenge<Long> {

    private final List<InstructionDef> instructions;

    private final State state = new State.Default();

    public Day08() {
        this(new StdInput(8).read());
    }

    public Day08(final String input) {
        this(
            Arrays.stream(input.split("\n"))
                .map(Day08::parseInstruction)
                .collect(Collectors.toList())
        );
    }

    @Override
    public Long run() {
        long highest = 0L;
        for (final InstructionDef instr : this.instructions) {
            new Instruction.Default(instr).run(this.state);
            final long current = this.currentHighestRegisterValue();
            if (current > highest) {
                highest = current;
            }
        }
        log.info("all-time high: {}", highest);
        return this.currentHighestRegisterValue();
    }

    private long currentHighestRegisterValue() {
        return this.state.registers().stream().mapToLong(this.state::readRegister).max().orElse(0L);
    }

    private static InstructionDef parseInstruction(final String input) {
        final String[] ifsplit = input.split(" if ");
        final String[] opsplit = ifsplit[0].trim().split("\\s+");
        return new InstructionDef.Default(
            opsplit[0],
            Day08.parseOperation(opsplit[1], Long.parseLong(opsplit[2])),
            Day08.parseCondition(ifsplit[1])
        );
    }

    private static OperationDef parseOperation(final String type, final long operand) {
        return new OperationDef.Default(
            operand,
            OperationDef.Type.valueOf(type.toUpperCase(Locale.ENGLISH))
        );
    }

    private static ConditionDef parseCondition(final String input) {
        final String[] split = input.trim().split("\\s+");
        return new ConditionDef.Default(
            split[0],
            Long.parseLong(split[2]),
            ConditionDef.Type.fromSymbol(split[1])
        );
    }

}
