package aoc.day14;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@ToString
@EqualsAndHashCode
final class Square {

    private final int row;

    private final int col;

}
