import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HoleTest {
    @Test
    void canCreateHoleWithAcceptableParAndHoleValue() {
        var hole = new Hole(1,5);

        assertNotNull(hole);
    }

    @Test
    void cannotCreateHoleWithParGreaterThanFive() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            var hole = new Hole(1, 6);
        });

        String expectedMessage = "Cannot assign par value greater than 5.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void cannotCreateHoleWithParLessThanThree() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            var hole = new Hole(1, 2);
        });

        String expectedMessage = "Cannot assign par value less than 3.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void cannotCreateHoleWithHoleNumberGreaterThanEighteen() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            var hole = new Hole(19, 3);
        });

        String expectedMessage = "Cannot assign hole number greater than 18.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void cannotCreateHoleWithHoleNumberLessThanOne() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            var hole = new Hole(0, 3);
        });

        String expectedMessage = "Cannot assign hole number less than 1.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
