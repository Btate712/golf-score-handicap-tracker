import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HoleScoreTest {
    @Test
    void canCreateScoreWithValidData() {
        var hole = new Hole(1, 4);
        var holeScore = new HoleScore(hole, 5, 2);

        assertNotNull(holeScore);
    }

    @Test
    void cannotScoreLessThanOne() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            var hole = new Hole(1, 4);
            var holeScore = new HoleScore(hole,0, 0);
        });

        String actualMessage = exception.getMessage();
        String expectedMessage = "Cannot record a score less than 1.";

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void cannotScoreGreaterThanTen() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            var hole = new Hole(1, 4);
            var holeScore = new HoleScore(hole, 11, 2);
        });

        String actualMessage = exception.getMessage();
        String expectedMessage = "Cannot record a score greater than 10.";

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void cannotRecordPutsLessThanZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            var hole = new Hole(1, 4);
            var holeScore = new HoleScore(hole, 5, -1);
        });

        String actualMessage = exception.getMessage();
        String expectedMessage = "Cannot record fewer than 0 puts.";

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void cannotRecordPutsGreaterThanScore() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            var hole = new Hole(1, 4);
            var holeScore = new HoleScore(hole, 3, 4);
        });

        String actualMessage = exception.getMessage();
        String expectedMessage = "Cannot record more puts than hole score.";

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
