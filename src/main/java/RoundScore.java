public class RoundScore {
    private HoleScore[] holeScores = new HoleScore[GlobalConstants.MAX_HOLE_NUMBER];

    public void addHoleScore(HoleScore holeScore) {
        if (holeScore != null) {
            int holeScoreIndex = holeScore.getHoleNumber() - 1;
            holeScores[holeScoreIndex] = holeScore;
        }
    }

    public int getTotalScore() {
        int runningScoreTotal = 0;
        for (HoleScore holeScore : holeScores) {
            if (holeScore != null) {
                runningScoreTotal += holeScore.getScore();
            }
        }
        return runningScoreTotal;
    }

    public int getNumberOfScoredHoles() {
        int runningHoleCount = 0;
        for (HoleScore holeScore : holeScores) {
            if (holeScore != null) {
                runningHoleCount++;
            }
        }
        return runningHoleCount;
    }

    public int getTotalPuts() {
        int runningTotalPuts = 0;
        for (HoleScore holeScore : holeScores) {
            if (holeScore != null) {
                runningTotalPuts += holeScore.getPuts();
            }
        }
        return runningTotalPuts;
    }
}
