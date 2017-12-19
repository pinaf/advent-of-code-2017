package aoc;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class StdInput {

    private final int day;

    private final boolean trim;

    public StdInput(final int day) {
        this(day, true);
    }

    public String read() {
        try {
            final String input = IOUtils.toString(
                StdInput.class.getResourceAsStream(
                    String.format("day%02d/day%02d.txt", this.day, this.day)
                ),
                Charset.defaultCharset()
            );
            if (this.trim) {
                return input.trim();
            } else {
                return input;
            }
        } catch (final IOException ex) {
            throw new IllegalStateException(ex);
        }
    }

}
