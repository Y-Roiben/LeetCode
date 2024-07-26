package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N皇后 {
    private final List<List<String>> res = new ArrayList<>();
    private char[][] board;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtracking(n, 0);
        return res;
    }

    private void backtracking(int n, int row) {
        if (row == n){
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(n, row, i)) continue;
            board[row][i] = 'Q';
            backtracking(n, row + 1);
            board[row][i] = '.';
        }
    }

    private boolean isValid(int n, int row, int col) {
        // 检查列
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // 检查左上角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // 检查右上角
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}