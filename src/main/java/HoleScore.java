public class HoleScore {
    private int score = GlobalConstants.MAX_HOLE_SCORE;
    private int puts;
    private Hole hole;

    public HoleScore(Hole hole, int score, int puts) {
        validateConstructorInput(hole, score, puts);
        this.hole = hole;
        this.score = score;
        this.puts = puts;
    }

    public int getScore() {
        return score;
    }

    public int getHoleNumber()
    {
        return hole.getHoleNumber();
    }

    private void validateConstructorInput(Hole hole, int score, int puts)
    {
        validateHole(hole);
        validateScore(score);
        validatePuts(score, puts);
    }

    private void validateHole(Hole hole) {
        if (hole == null) {
            throw new NullPointerException("Cannot supply null value for hole object.");
        }
    }

    private void validateScore(int score) {
        if (score < 1) {
            throw new IllegalArgumentException("Cannot record a score less than 1.");
        }

        if (score > GlobalConstants.MAX_HOLE_SCORE) {
            throw new IllegalArgumentException("Cannot record a score greater than " + GlobalConstants.MAX_HOLE_SCORE + ".");
        }
    }

    private void validatePuts(int score, int puts) {
        if (puts < 0) {
            throw new IllegalArgumentException("Cannot record fewer than 0 puts.");
        }

        if (puts > score) {
            throw new IllegalArgumentException("Cannot record more puts than hole score.");
        }
    }

    public int getPuts() {
        return puts;
    }
}
