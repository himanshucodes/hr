package hr1;

import java.util.*;

/**
 * Time Complexity: O(nlog(n))
 * Space Complexity: O(n)
 */
public class CompetitiveGaming {
    public int numPlayers(int playerCutOffCount, List<Integer> scores) {
        int numPlayersPassingToNextRound = 0;
        Map<Integer, Integer> playerScoreCount = new HashMap<>();
        for (Integer score : scores) {
            playerScoreCount.put(score, 1 + playerScoreCount.getOrDefault(score, 0));
        }

        List<Integer> sortedKeys = new ArrayList<>(playerScoreCount.keySet());
        sortedKeys.sort(Collections.reverseOrder()); // Time Complexity: O(nlog(n))

        int loopCount = 0;
        for (Integer key : sortedKeys) {
            if (loopCount == playerCutOffCount) {
                break;
            }
            if (key == 0) {
                continue;
            }
            numPlayersPassingToNextRound += playerScoreCount.get(key);
            loopCount++;
        }
        return numPlayersPassingToNextRound;
    }
}
