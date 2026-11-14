class Solution {
    boolean[][] visited;

    private void bfs(char[][] grid, int[] coords) {
        Queue<int[]> q = new LinkedList<>();

        visited[coords[0]][coords[1]] = true;
        q.add(coords);

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            // visit all unvisited neighbors of currNode
            int[] up = new int[]{x - 1, y};
            int[] down = new int[]{x + 1, y};
            int[] left = new int[]{x, y - 1};
            int[] right = new int[]{x, y + 1};

            int[][] adj = new int[][]{up, down, left, right};

            for (int[] direction : adj) {
                int dx = direction[0];
                int dy = direction[1];

                if (dx < 0 || dx >= grid.length || dy < 0 || dy >= grid[0].length ||
                    grid[dx][dy] == '0' || visited[dx][dy]) {
                    continue;
                }
                q.add(direction);
                visited[dx][dy] = true;;
            }
        }
    }

    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;

        visited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    bfs(grid, new int[]{r, c});
                    islands++;
                }
            }
        }
        return islands;
    }
}
