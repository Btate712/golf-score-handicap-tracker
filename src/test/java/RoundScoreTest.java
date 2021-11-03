import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundScoreTest {
    @Test
    void getsNumberOfScoredHoles() {
        RoundScore roundScore = makeTestRoundScore();

        int actualNumberOfScoredHoles = roundScore.getNumberOfScoredHoles();
        assertEquals(18, actualNumberOfScoredHoles);
    }

    @Test
    void getsTotalPuts() {
        RoundScore roundScore = makeTestRoundScore();

        int actualNumberOfPuts = roundScore.getTotalPuts();
        assertEquals(36, actualNumberOfPuts);
    }

    @Test
    void getsTotalRoundScore() {
        RoundScore roundScore = makeTestRoundScore();

        int actualTotalScore = roundScore.getTotalScore();
        assertEquals(5 * 18, actualTotalScore);
    }

    private RoundScore makeTestRoundScore() {
        var roundScore = new RoundScore();

        for (int i = 0; i < 18; i++) {
            int holeNumber = i + 1;
            var hole = new Hole(holeNumber, 4);
            var holeScore = new HoleScore(hole, 5, 2);
            roundScore.addHoleScore(holeScore);
        }

        return roundScore;
    }
}
