package hr2;

import java.util.List;

public class BandwidthDistribution {
    public long getMaxRequests(List<Integer>bandwidths, List<Integer> requests, int totalBandwidth) {
        // Knapsack Problem
        long[][] dp = new long[bandwidths.size() + 1][totalBandwidth + 1];

        // O(bandwidths.size() * totalBandwidth)
        for (int row = 1; row <= bandwidths.size(); row++) {
            for (int col = 0; col <= totalBandwidth; col++) {
                int bandwidth = bandwidths.get(row - 1);
                long valueFromDP = dp[row - 1][col];
                if (bandwidth <= col) {
                    long valueFromRequestsPlusDP = requests.get(row - 1) + dp[row - 1][col - bandwidth];
                    dp[row][col] = Math.max(valueFromRequestsPlusDP,
                            valueFromDP);
                }
                else {
                    dp[row][col] = valueFromDP;
                }
            }
        }

        return dp[bandwidths.size()][totalBandwidth];
    }
}
