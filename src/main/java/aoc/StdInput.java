package aoc;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class StdInput {

    private final int day;

    public String read() {
        try {
            return IOUtils.toString(
                StdInput.class.getResourceAsStream(
                    String.format("day%02d/day%02d.txt", this.day, this.day)
                ),
                Charset.defaultCharset()
            ).trim();
        } catch (final IOException ex) {
            throw new IllegalStateException(ex);
        }
    }

}
