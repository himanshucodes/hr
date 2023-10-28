package hr1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompetitiveGamingTest {
    CompetitiveGaming competitiveGaming;
    @BeforeEach
    void setUp() {
        competitiveGaming = new CompetitiveGaming();
    }

    @Test
    @DisplayName(value="Scores [20, 40, 60, 80, 100] with Cutoff 4 Returns 4")
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
    @DisplayName(value="Scores [2, 2, 3, 4, 5] with Cutoff 4 Returns 5")
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
    @DisplayName(value="Scores [1, 2, 3, 4, 5] with Cutoff 4 Returns 4")
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
    @DisplayName(value="Scores [0, 0, 0, 0, 5] with Cutoff 3 Returns 1")
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
    @DisplayName(value="Scores [10, 20, 30, 30, 50] with Cutoff 1 Returns 1")
    void s10_20_30_40_50Cutoff1Returns1() {
        List<Integer> scores = new ArrayList<>(5);
        scores.add(10);
        scores.add(20);
        scores.add(30);
        scores.add(30);
        scores.add(50);
        int cutoff = 1;

        assertEquals(1, competitiveGaming.numPlayers(cutoff, scores));
    }

    @Test
    @DisplayName(value="Scores [10, 20, 30, 40, 50, 50] with Cutoff 1 Returns 2")
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
}