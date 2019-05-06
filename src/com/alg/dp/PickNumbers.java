package com.alg.dp;

public class PickNumbers {
    public static void main(String[] args) {
        pick(n, m);
    }

    static int n = 10;
    static int m = 30;
    static int[] flag = new int[100];

    public static void pick(int n, int m) {

        if (n < 1 || m < 1)
            return;
        if (n > m) n = m;

        if (n == m) {
            flag[n - 1] = 1;
            for (int i = 0; i < n; i++)
                if (flag[i] == 1)
                    System.out.print(i + 1 + " ");
            System.out.printf("\n");
            flag[n - 1] = 0;
        }

        flag[n - 1] = 1;
        pick(n - 1, m - n);

        flag[n - 1] = 0;
        pick(n - 1, m);
    }
}
