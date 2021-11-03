import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TeePositionTest {
    @Test
    void canCreateNewTeePosition() {
        var teePosition = new TeePosition("black", 135, 72.2f);

        assertNotNull(teePosition);
    }
}
