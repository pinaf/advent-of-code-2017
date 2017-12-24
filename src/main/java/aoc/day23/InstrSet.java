package aoc.day23;

public final class InstrSet implements Instruction {

    @Override
    public void run(final InstructionEnv env) {
        env.state().setRegister(env.operand1(), env.operand2());
        env.state().incrementProgramCounter();
    }

}
