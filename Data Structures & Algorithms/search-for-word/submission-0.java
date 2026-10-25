class Solution {
    public record Pair<K, V>(K key, V value) {}
    Set<Pair> visited = new HashSet<>();
    int wordIndex = 0;
    boolean result = false;
    
    private void backtrack(char[][] board, int i, int j, String word) {
        int n = board.length;    // rows
        int m = board[0].length; // cols
        
        if (wordIndex == word.length()) {
            result = true;
            return;
        }

        if (result) {
            return;
        }
        
        Pair boardLocation = new Pair(i, j);
        char target = word.charAt(wordIndex);
        if (i < 0 || i >= n || j < 0 || j >= m || visited.contains(boardLocation) || board[i][j] != target) {
            return;
        }
        visited.add(boardLocation);
        wordIndex++;

        backtrack(board, i-1, j, word);
        backtrack(board, i+1, j, word);
        backtrack(board, i, j-1, word);
        backtrack(board, i, j+1, word);

        visited.remove(boardLocation);
        wordIndex--;
        return;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, i, j, word);
            }
        }
        return result;
    }
}
