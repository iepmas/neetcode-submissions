class Solution {
    boolean result = false;
    Set<List<Integer>> set = new HashSet<>();

    private void backtrack(char[][] board, int i, int j, int wordIndex, String word) {
        int n = board.length;
        int m = board[0].length;

        if (i < 0 || i == n || j < 0 || j == m || board[i][j] != word.charAt(wordIndex)) {
            return;
        }

        List<Integer> coords = new ArrayList<>(Arrays.asList(i, j));        
        if (set.contains(coords)) {
            return;
        }
        
        if (wordIndex == word.length() - 1) {
            result = true;
            return;
        }

        set.add(coords);
        
        backtrack(board, i + 1, j, wordIndex + 1, word);
        backtrack(board, i - 1, j, wordIndex + 1, word);
        backtrack(board, i, j + 1, wordIndex + 1, word);
        backtrack(board, i, j - 1, wordIndex + 1, word);

        set.remove(coords);
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, i, j, 0, word);
            }
        }
        return result;
    }
}
