package aoc.day16;

public interface ProgramSequence {

    void spin(int units);

    void exchange(int left, int right);

    void partner(int left, int right);

}
