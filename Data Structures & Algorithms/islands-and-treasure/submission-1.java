class Solution {
    int land = Integer.MAX_VALUE;

    // do an initial sweep of the grid. This shouldn't add any substantial time. We note down where the treasures are.
    Queue<int[]> q = new LinkedList<>();
    boolean[][] visited;

    private void bfs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] coords = q.poll();
                int x = coords[0];
                int y = coords[1];

                // process neighbors
                int[] up = new int[]{x, y - 1};
                int[] down = new int[]{x, y + 1};
                int[] left = new int[]{x - 1, y};
                int[] right = new int[]{x + 1, y};

                int[][] directions = new int[][]{up, down, left, right};

                for (int[] direction : directions) {
                    int dx = direction[0];
                    int dy = direction[1];

                    if (dx < 0 || dy < 0 || dx >= m || dy >= n ||
                        visited[dx][dy] || grid[dx][dy] == -1) {
                            continue;
                    }
                    visited[dx][dy] = true;
                    q.offer(new int[]{dx,dy});
                }

                if (level != 0) {
                    grid[x][y] = level;
                }
            }
            level++;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        
        bfs(grid);
    }
}
