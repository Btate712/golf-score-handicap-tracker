import java.util.ArrayList;
import java.util.List;

public class GolfCourse {
    String courseName;

    private Hole[] holes = new Hole[GlobalConstants.MAX_HOLE_NUMBER];

    private List<TeePosition> teePositions = new ArrayList<TeePosition>();

    public GolfCourse(String name) {
        courseName = name;
    }

    public GolfCourse() {
    }

    public void setCourseName(String name) {
        courseName = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addTeePosition(TeePosition teePosition) {
        validateTeePosition(teePosition);
        teePositions.add(teePosition);
    }

    private void validateTeePosition(TeePosition teePosition) {
        if (teePosition == null) {
            throw new IllegalArgumentException("Cannot add null tee position.");
        }

        if (teePosition.getSlope() == 0) {
            throw new IllegalArgumentException("Cannot add tee position without specifying slope.");
        }

        if (teePosition.getRating() == 0.0f) {
            throw new IllegalArgumentException("Cannot add tee position without specifying rating.");
        }

        if (teePosition.getColor() == null || teePosition.getColor().isEmpty()) {
            throw new IllegalArgumentException("Cannot add tee position without color/position specified.");
        }
    }

    public void addHole(Hole newHole) {
        if (newHole.getHoleNumber() <= GlobalConstants.MAX_HOLE_NUMBER && validateHole(newHole)) {
            int holeIndex = newHole.getHoleNumber() - 1;
            holes[holeIndex] = newHole;
        }
    }

    public Hole getHole(int holeNumber) {
        if (holeNumber > GlobalConstants.MAX_HOLE_NUMBER) {
            return null;
        }
        else {
            int holeIndex = holeNumber -1;
            return holes[holeIndex];
        }
    }

    private boolean validateHole(Hole newHole) {
        return newHole.getHoleNumber() <= GlobalConstants.MAX_HOLE_NUMBER && newHole.getHolePar() < GlobalConstants.MAX_PAR;
    }

    public int getNumberOfHoles() {
        int numberOfHoles = 0;
        for (Hole hole : holes) {
            if (hole != null) {
                numberOfHoles++;
            }
        }

        return numberOfHoles;
    }

    public int getParForCourse() {
        int runningParTotal = 0;

        for (Hole hole : holes) {
            if (hole != null) {
                runningParTotal += hole.getHolePar();
            }
        }

        return runningParTotal;
    }

    public List<TeePosition> getTeePositions() {
        return teePositions;
    }
}
