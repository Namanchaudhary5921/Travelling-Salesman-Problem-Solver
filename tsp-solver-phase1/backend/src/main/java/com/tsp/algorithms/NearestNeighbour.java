package com.tsp.algorithms;

public class NearestNeighbour {

    public static int[] solve(int[][] matrix) {

        int n = matrix.length;
        boolean[] visited = new boolean[n];
        int[] path = new int[n + 1];

        int current = 0;
        path[0] = 0;
        visited[0] = true;

        for (int i = 1; i < n; i++) {
            int next = -1;
            int minDist = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && matrix[current][j] < minDist) {
                    minDist = matrix[current][j];
                    next = j;
                }
            }

            path[i] = next;
            visited[next] = true;
            current = next;
        }

        path[n] = 0;
        return path;
    }
}