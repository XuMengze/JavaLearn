package com.alg.array;

import java.util.Arrays;
import java.util.Scanner;

public class WorkOrGym {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days;
        days = sc.nextInt();
        int[] work = new int[days];
        int[] gym = new int[days];
        for (int i = 0; i < days; i++) {
            work[i] = sc.nextInt();
        }
        for (int i = 0; i < days; i++) {
            gym[i] = sc.nextInt();
        }
        int[] workOrGym = new int[days];
        Arrays.fill(workOrGym, 0);
        for (int i = 0; i < days; i++) {
            if (work[i] == 1 && gym[i] == 1) {
                workOrGym[i] = 3;
            } else if (work[i] == 1 && gym[i] != 1) {
                workOrGym[i] = 1;
            } else if (work[i] != 1 && gym[i] == 1) {
                workOrGym[i] = 2;
            } else {
                workOrGym[i] = 0;
            }
        }
        int res = days + 1;
        for (int i = 0; i < days; i++) {
            if (workOrGym[i] == 1) {
                int count = 1;
                for (int j = i + 1; j < days; j++) {
                    count++;
                    if (workOrGym[j] == 2 || workOrGym[j] == 3) {
                        if (count < res) {
                            res = count;
                        }
                        i = j;
                        break;
                    }
                }
            }
            if (workOrGym[i] == 2) {
                int count = 1;
                for (int j = i + 1; j < days; j++) {
                    count++;
                    if (workOrGym[j] == 1 || workOrGym[j] == 3) {
                        if (count < res) {
                            res = count;
                        }
                        i = j;
                        break;
                    }
                }
            }
            if (workOrGym[i] == 3) {
                int count = 1;
                for (int j = i + 1; j < days; j++) {
                    count++;
                    if (workOrGym[j] == 1 || workOrGym[j] == 2) {
                        if (count < res) {
                            res = count;
                        }
                        i = j;
                        break;
                    }
                }
            }
        }

        System.out.println(res);
    }
}
