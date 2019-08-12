package com.alg.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FloodAndRod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        int stationCount = sc.nextInt();
        int[] station = new int[stationCount];
        for (int i = 0; i < stationCount; i++) {
            station[i] = sc.nextInt();
        }
        int floodCount = sc.nextInt();
        int[] flood = new int[floodCount];
        for (int i = 0; i < floodCount; i++) {
            flood[i] = sc.nextInt();
        }

        for (Integer i : flood) {
            res.add(deal(station, i));
        }

        for (Integer i : res
        ) {
            System.out.println(i);
        }
    }

    public static int deal(int[] stationInput, int flood) {
        int partition = 0;
        int[] station = stationInput.clone();
        for (int i = 0, len = station.length; i < len; i++) {
            station[i] = Math.max(0, station[i] - flood);
        }
        if (station.length == 0) {
            return 0;
        }
        if (station.length == 1) {
            return station[0] == 0 ? 0 : 1;
        }
        for (int i = 1, len = station.length; i < len; i++) {
            if (station[i] != 0 && station[i - 1] != 0) {
                station[i - 1] = 0;
            }
        }
        for (int i = 0, len = station.length; i < len; i++) {
            if (station[i] != 0) {
                partition++;
            }
        }
        return partition;
    }
}
