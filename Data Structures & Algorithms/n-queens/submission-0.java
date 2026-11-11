class Solution {
    // count number of queens?
    // global state of board?
    // hard code the solution.
    // what would be the check for valid state? Perhaps helper function for this.

    List<List<String>> result = new ArrayList<>();

    private boolean isValid(char[][] board, int row, int col) {
        for (int r = 0; r < row; r++) {
            if (board[r][col] == 'Q') {
                return false;
            }
        }

        for (int r = row - 1, c = col - 1;
             r >= 0 && c >= 0;
             r--, c--) {
                if (board[r][c] == 'Q') {
                    return false;
                }
        }

        for (int r = row - 1, c = col + 1;
             r >= 0 && c < board.length;
             r--, c++) {
                if (board[r][c] == 'Q') {
                    return false;
                }
        }

        return true;
    }
    
    private List<String> createBoard(char[][]board) {
        List<String> newBoard = new ArrayList<>();

        for (char[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (char c : row) {
                sb.append(c);
            }
            newBoard.add(sb.toString());
        }

        return newBoard;
    }

    private void backtrack(char[][]board, int row) {
        if (row == board.length) {
            result.add(createBoard(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(board, 0);

        return result;
    }
}
