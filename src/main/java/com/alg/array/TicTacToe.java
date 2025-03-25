package com.alg.array;

import java.util.Arrays;
import java.util.List;

public class TicTacToe {
    private static int BOARD_SIZE = 3;

    public int whoWins(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            int sumRow = calculateSum(board, 0, i, 0, 0, 1);
            if (sumRow == 3 || sumRow == -3) {
                return sgn(sumRow);
            }
            int sumCol = calculateSum(board, 0, 0, i, 1, 0);
            if (sumCol == 3 || sumCol == -3) {
                return sgn(sumCol);
            }
        }
        int principalDiagonal = calculateSum(board, 0, 0, 0, 1, 1);
        if (principalDiagonal == 3 || principalDiagonal == -3) {
            return sgn(principalDiagonal);
        }
        int antiDiagonal = calculateSum(board, 0, 0, 2, 1, -1);
        if (antiDiagonal == 3 || antiDiagonal == -3) {
            return sgn(antiDiagonal);
        }
        return 0;
    }

    private int calculateSum(int[][] board, int sum, int row, int col, int nextRow, int nextCol) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
            return sum;
        }
        return sum + calculateSum(board, sum + board[row][col], row + nextRow, col + nextCol, nextRow, nextCol);
    }

    private int sgn(int original) {
        if (original > 0) {
            return 1;
        } else if (original < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
