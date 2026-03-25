package com.tsp.utils;

public class DistanceUtil {

    public static int[][] buildMatrix(int[][] coords) {
        int n = coords.length;
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int dx = coords[i][0] - coords[j][0];
                int dy = coords[i][1] - coords[j][1];

                matrix[i][j] = (int) Math.sqrt(dx * dx + dy * dy);
            }
        }

        return matrix;
    }
}