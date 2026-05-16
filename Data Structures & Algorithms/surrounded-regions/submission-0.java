class Solution {
    int rows;
    int cols;

    public void solve(char[][] board) {

        rows = board.length;
        cols = board[0].length;

        // Mark all border-connected O's as temporary 'T'

        // top row
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }
        }

        // bottom row
        for (int c = 0; c < cols; c++) {
            if (board[rows - 1][c] == 'O') {
                dfs(board, rows - 1, c);
            }
        }

        // left column
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }
        }

        // right column
        for (int r = 0; r < rows; r++) {
            if (board[r][cols - 1] == 'O') {
                dfs(board, r, cols - 1);
            }
        }

        // Convert surrounded O -> X
        // Convert safe T -> O

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }

                else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int r, int c) {

        // boundary check
        if (r < 0 || c < 0 ||
            r >= rows || c >= cols) {

            return;
        }

        // only process O
        if (board[r][c] != 'O') {
            return;
        }

        // mark safe
        board[r][c] = 'T';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
        
    }
}
