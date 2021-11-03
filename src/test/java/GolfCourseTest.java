import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GolfCourseTest {
    @Test
    void canAddTeePositionWithColorSlopeAndRating() {
        var teePosition = new TeePosition("green", 130, 70.4f);
        var golfCourse = new GolfCourse("Lincolnshire Country Club");

        golfCourse.addTeePosition(teePosition);

        assertTrue(golfCourse.getTeePositions().size() > 0);
    }

    @Test
    void cannotAddTeePositionWithoutSpecifyingColor() {
        var teePosition = new TeePosition(null, 130, 70.4f);
        var golfCourse = new GolfCourse("Lincolnshire Country Club");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            golfCourse.addTeePosition(teePosition);
        });

        String actualMessage = exception.getMessage();
        String expectedMessage = "Cannot add tee position without color/position specified.";

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void cannotAddTeePositionWithEmptyColor() {
        var teePosition = new TeePosition("", 130, 70.4f);
        var golfCourse = new GolfCourse("Lincolnshire Country Club");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            golfCourse.addTeePosition(teePosition);
        });

        String actualMessage = exception.getMessage();
        String expectedMessage = "Cannot add tee position without color/position specified.";

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void cannotAddTeePositionWithZeroSlope() {
        var teePosition = new TeePosition("green", 0, 70.4f);
        var golfCourse = new GolfCourse("Lincolnshire Country Club");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            golfCourse.addTeePosition(teePosition);
        });

        String actualMessage = exception.getMessage();
        String expectedMessage = "Cannot add tee position without specifying slope.";

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void cannotAddTeePositionWithZeroRating() {
        var teePosition = new TeePosition("green", 130, 0.0f);
        var golfCourse = new GolfCourse("Lincolnshire Country Club");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            golfCourse.addTeePosition(teePosition);
        });

        String actualMessage = exception.getMessage();
        String expectedMessage = "Cannot add tee position without specifying rating.";

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void unassignedHoleIsNull() {
        var golfCourse = new GolfCourse();

        assertNull(golfCourse.getHole(1));
    }

    @Test
    void getsParForCourse() {
        GolfCourse golfCourse = makeTestParThreeGolfCourse();

        assertEquals(18 * 3, golfCourse.getParForCourse());
    }

    @Test
    void getsNumberOfHolesForCourse() {
        GolfCourse golfCourse = makeTestParThreeGolfCourse();

        assertEquals(18, golfCourse.getNumberOfHoles());
    }

    @Test
    void numberOfHolesDoesNotCountNulls() {
        var golfCourse = new GolfCourse();
        var hole = new Hole(3,3);
        golfCourse.addHole(hole);

        assertEquals(1, golfCourse.getNumberOfHoles());
    }

    private GolfCourse makeTestParThreeGolfCourse() {
        var golfCourse = new GolfCourse();
        for (int i = 0; i < GlobalConstants.MAX_HOLE_NUMBER; i++)
        {
            int holeNumber = i + 1;
            int par = 3;

            var currentHole = new Hole(holeNumber, par);

            golfCourse.addHole(currentHole);
        }

        return golfCourse;
    }


}
