package com.tsp.algorithms;

public class BruteForce {

    static int minCost = Integer.MAX_VALUE;
    static int[] bestPath;

    public static int[] solve(int[][] matrix) {
        int n = matrix.length;

        boolean[] visited = new boolean[n];
        int[] path = new int[n + 1];

        visited[0] = true;
        path[0] = 0;

        dfs(matrix, visited, path, 1, 0);

        return bestPath;
    }

    private static void dfs(int[][] matrix, boolean[] visited, int[] path, int level, int cost) {
        int n = matrix.length;

        if (level == n) {
            cost += matrix[path[level - 1]][0];

            if (cost < minCost) {
                minCost = cost;
                bestPath = path.clone();
                bestPath[n] = 0;
            }
            return;
        }

        for (int i = 1; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path[level] = i;

                dfs(matrix, visited, path, level + 1,
                        cost + matrix[path[level - 1]][i]);

                visited[i] = false;
            }
        }
    }
}