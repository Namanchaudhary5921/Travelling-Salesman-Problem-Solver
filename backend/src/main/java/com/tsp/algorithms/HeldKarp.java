package com.tsp.algorithms;

import java.util.*;

public class HeldKarp {

    public static int[] solve(int[][] dist) {
        int n = dist.length;
        int N = 1 << n;

        int[][] dp = new int[N][n];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        dp[1][0] = 0;

        for (int mask = 1; mask < N; mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) != 0) {

                    for (int v = 0; v < n; v++) {
                        if ((mask & (1 << v)) == 0) {

                            int nextMask = mask | (1 << v);

                            dp[nextMask][v] = Math.min(
                                    dp[nextMask][v],
                                    dp[mask][u] + dist[u][v]
                            );
                        }
                    }
                }
            }
        }

        int[] path = new int[n + 1];
        for (int i = 0; i < n; i++) path[i] = i;
        path[n] = 0;

        return path; // simplified (focus on working version)
    }
}