import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 16, 2021
 * Questions: https://leetcode.com/problems/design-tic-tac-toe/
 */

public class DesignTicTacToe {

    public static void main(String[] args) {

    }

    static class TicTacToe {

        int[][] grid;
        int winner = 0;

        public TicTacToe(int n) {
            grid = new int[n][n];
        }

        /**
         * Player {player} makes a move at ({row}, {col}).
         *
         * @param row    The row of the board.
         * @param col    The column of the board.
         * @param player The player, can be either 1 or 2.
         * @return The current winning condition, can be either:
         * 0: No one wins.
         * 1: Player 1 wins.
         * 2: Player 2 wins.
         */
        public int move(int row, int col, int player) {
            if (winner != 0) return winner; // Invalid operation.
            // row--;
            // col--;
            grid[row][col] = player;
            computeWinner(row, col);
            // System.out.println(Arrays.deepToString(grid));
            return winner;
        }

        private void computeWinner(int row, int col) {
            if (checkRow(row)) return;
            if (checkCol(col)) return;
            if (row == col) checkDaiognal1();
            if (row + col == grid.length - 1) checkDaiognal2();
        }

        private void checkDaiognal2() {
            int n = grid.length - 1, pre = grid[n][0];
            for (int i = 0; i < grid.length; i++) {
                int cur = grid[n - i][i];
                if (cur != pre) return;
                pre = cur;
            }
            winner = pre != 0 ? pre : winner;
        }

        private void checkDaiognal1() {
            int pre = grid[0][0];
            for (int i = 0; i < grid.length; i++) {
                int cur = grid[i][i];
                if (cur != pre) return;
                pre = cur;
            }
            winner = pre != 0 ? pre : winner;
        }

        private boolean checkCol(int col) {
            int pre = grid[0][col];
            for (int[] row : grid) {
                int cur = row[col];
                if (cur != pre) return false;
                pre = cur;
            }
            winner = pre != 0 ? pre : winner;
            return pre != 0;
        }

        private boolean checkRow(int row) {
            int pre = grid[row][0];
            for (int cur : grid[row]) {
                if (cur != pre) return false;
                pre = cur;
            }
            winner = pre != 0 ? pre : winner;
            return pre != 0;
        }
    }
}
