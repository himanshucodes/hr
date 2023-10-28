package hr1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompetitiveGamingTest {
    CompetitiveGaming competitiveGaming;

    @BeforeEach
    void setUp() {
        competitiveGaming = new CompetitiveGaming();
    }

    @Test
    @DisplayName(value = "Scores [20, 40, 60, 80, 100] with Cutoff 4 Returns 4")
    void s20_40_60_80_100Cutoff4Returns4() {
        List<Integer> scores = new ArrayList<>(5);
        scores.add(20);
        scores.add(40);
        scores.add(60);
        scores.add(80);
        scores.add(100);
        int cutoff = 4;

        assertEquals(4, competitiveGaming.numPlayers(cutoff, scores));
    }

    @Test
    @DisplayName(value = "Scores [2, 2, 3, 4, 5] with Cutoff 4 Returns 5")
    void s2_2_3_4_5Cutoff4Returns5() {
        List<Integer> scores = new ArrayList<>(5);
        scores.add(2);
        scores.add(2);
        scores.add(3);
        scores.add(4);
        scores.add(5);
        int cutoff = 4;

        assertEquals(5, competitiveGaming.numPlayers(cutoff, scores));
    }

    @Test
    @DisplayName(value = "Scores [1, 2, 3, 4, 5] with Cutoff 4 Returns 4")
    void s1_2_3_4_5Cutoff4Returns5() {
        List<Integer> scores = new ArrayList<>(5);
        scores.add(1);
        scores.add(2);
        scores.add(3);
        scores.add(4);
        scores.add(5);
        int cutoff = 4;

        assertEquals(4, competitiveGaming.numPlayers(cutoff, scores));
    }

    @Test
    @DisplayName(value = "Scores [0, 0, 0, 0, 5] with Cutoff 3 Returns 1")
    void s0_0_0_0_5Cutoff4Returns1() {
        List<Integer> scores = new ArrayList<>(5);
        scores.add(0);
        scores.add(0);
        scores.add(0);
        scores.add(0);
        scores.add(5);
        int cutoff = 3;

        assertEquals(1, competitiveGaming.numPlayers(cutoff, scores));
    }

    @Test
    @DisplayName(value = "Scores [10, 20, 30, 30, 50] with Cutoff 2 Returns 3")
    void s10_20_30_30_50Cutoff1Returns1() {
        List<Integer> scores = new ArrayList<>(5);
        scores.add(10);
        scores.add(20);
        scores.add(30);
        scores.add(30);
        scores.add(50);
        int cutoff = 2;

        assertEquals(3, competitiveGaming.numPlayers(cutoff, scores));
    }

    @Test
    @DisplayName(value = "Scores [10, 20, 30, 40, 50, 50] with Cutoff 1 Returns 2")
    void s10_20_30_40_50_50Cutoff1Returns1() {
        List<Integer> scores = new ArrayList<>(6);
        scores.add(10);
        scores.add(20);
        scores.add(30);
        scores.add(40);
        scores.add(50);
        scores.add(50);
        int cutoff = 1;

        assertEquals(2, competitiveGaming.numPlayers(cutoff, scores));
    }

    @Test
    @DisplayName(value = "Scores [0, 0, 0, 0, 0, 0] with Cutoff 5 Returns 0")
    void s0_0_0_0_0_0Cutoff5Returns0() {
        List<Integer> scores = new ArrayList<>(6);
        scores.add(0);
        scores.add(0);
        scores.add(0);
        scores.add(0);
        scores.add(0);
        scores.add(0);
        int cutoff = 5;

        assertEquals(0, competitiveGaming.numPlayers(cutoff, scores));
    }

    @Test
    @DisplayName(value = "10,000 Scores with Cutoff 15,000 Returns 10,000")
    void s10_000ScoresCutoff15_000Returns10_000() {
        List<Integer> scores = generateNonZeroScores(10_000);
        int cutoff = 15_000;

        assertEquals(10_000, competitiveGaming.numPlayers(cutoff, scores));
    }

    @Test
    @DisplayName(value = "10,000 Scores with Cutoff 50 Returns 50")
    void s10_000ScoresCutoff50Returns50() {
        List<Integer> scores = generateNonZeroScores(10_000);
        int cutoff = 50;

        assertEquals(50, competitiveGaming.numPlayers(cutoff, scores));
    }

    @Test
    @DisplayName(value = "5,000 Scores with Alternating 0's with Cutoff 10 Returns 10")
    void s5_000ScoresCutoff10Returns10() {
        List<Integer> scores = generateScoresWithAlternatingScoresAs0(5_000);
        int cutoff = 10;

        assertEquals(10, competitiveGaming.numPlayers(cutoff, scores));
    }

    @Test
    @DisplayName(value = "1,000,000 Scores With Ties for 1st, 2nd, and 3rd with Cutoff 3 Returns 7")
    void s1_000_000ScoresCutoff3Returns7() {
        List<Integer> scores = generateNonZeroScores(1_000_000);
        scores.add(1_000_000);
        scores.add(999_999);
        scores.add(999_999);
        scores.add(999_998);
        int cutoff = 3;

        assertEquals(7, competitiveGaming.numPlayers(cutoff, scores));
    }

    private List<Integer> generateNonZeroScores(int numScores) {
        List<Integer> scores = new ArrayList<>(numScores);
        for (int s = 0; s < numScores; s++) {
            scores.add(s + 1);
        }
        assertEquals(numScores, scores.size());
        return scores;
    }

    private List<Integer> generateScoresWithAlternatingScoresAs0(int numScores) {
        List<Integer> scores = new ArrayList<>(numScores);
        for (int s = 0; s < numScores; s++) {
            if (s % 2 == 0) {
                scores.add(0);
            }
            else {
                scores.add(s + 1);
            }
        }
        assertEquals(numScores, scores.size());
        return scores;
    }
}