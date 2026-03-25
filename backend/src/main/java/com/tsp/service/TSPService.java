package com.tsp.service;

import com.tsp.algorithms.*;
import com.tsp.model.*;
import com.tsp.utils.DistanceUtil;

public class TSPService {

    public static Response solve(Request req) {

        long start = System.currentTimeMillis();

        int[][] matrix = DistanceUtil.buildMatrix(req.coordinates);

        int[] path;

        switch (req.algorithm) {
            case "NN":
                path = NearestNeighbour.solve(matrix);
                break;
            case "BRUTE":
                path = BruteForce.solve(matrix);
                break;
            default:
                path = HeldKarp.solve(matrix);
        }

        int cost = calculateCost(path, matrix);

        long end = System.currentTimeMillis();

        Response res = new Response();
        res.path = path;
        res.cost = cost;
        res.time = end - start;

        return res;
    }

    private static int calculateCost(int[] path, int[][] matrix) {
        int cost = 0;
        for (int i = 0; i < path.length - 1; i++) {
            cost += matrix[path[i]][path[i + 1]];
        }
        return cost;
    }
}