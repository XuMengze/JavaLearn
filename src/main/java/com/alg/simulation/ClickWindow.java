package com.alg.simulation;

import java.util.Arrays;
import java.util.Scanner;

public class ClickWindow {


//    2(windows) 4(operations)
//    100 100 100 100 (x,y,width,height)
//    10 10 150 150
//    105 105 (click_x,click_y)
//    180 180
//    105 105
//    1 1

    private static final int WIDTH = 3840;
    private static final int HEIGHT = 2160;

    public static void main(String[] args) {
        int[][] screen = new int[HEIGHT][WIDTH];
        for (int[] arr : screen
        ) {
            Arrays.fill(arr, -1);
        }

        Scanner scanner = new Scanner(System.in);
        int windowNum = scanner.nextInt();
        int oprCount = scanner.nextInt();

        int[][] windows = new int[windowNum][4];
        for (int i = 0; i < windowNum; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            windows[i] = new int[]{x, y, Math.min(x + w, WIDTH), Math.min(y + h, HEIGHT)};
        }
        int[][] oprs = new int[oprCount][2];
        for (int i = 0; i < oprCount; i++) {
            oprs[i] = new int[]{scanner.nextInt(), scanner.nextInt()};
        }
        initialize(screen, windows);
        for (int[] opr : oprs
        ) {
            System.out.println(click(screen, windows, opr));
        }

    }

    static void initialize(int[][] screen, int[][] windows) {
        int index = 0;
        for (int[] window : windows
        ) {
            for (int i = window[1]; i >= window[1] && i <= window[3]; i++) {
                for (int j = window[0]; j >= window[0] && j <= window[2]; j++) {
                    screen[i][j] = index;
                }
            }
            index++;
        }
    }

    static int click(int[][] screen, int[][] windows, int[] position) {
        if (screen[position[0]][position[1]] == -1)
            return -1;
        else {
            int windowIndex = screen[position[0]][position[1]];
            for (int i = windows[windowIndex][1]; i >= windows[windowIndex][1] && i <= windows[windowIndex][3]; i++) {
                for (int j = windows[windowIndex][0]; j >= windows[windowIndex][0] && j <= windows[windowIndex][2]; j++) {
                    screen[i][j] = windowIndex;
                }
            }
            return windowIndex + 1;
        }
    }

}
