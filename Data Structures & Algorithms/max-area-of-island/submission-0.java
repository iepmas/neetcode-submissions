class Solution {
    boolean[][] visited;
    private int bfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        
        int[] coords = new int[]{r, c};

        visited[r][c] = true;
        int m = grid.length;
        int n = grid[0].length;
        
        q.add(coords);
        int currArea = 0;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            currArea++;

            int[] up = new int[]{x, y - 1};
            int[] down = new int[]{x, y + 1};
            int[] left = new int[]{x - 1, y};
            int[] right = new int[]{x + 1, y};

            int[][] direction = new int[][]{up, down, left, right};

            for (int[] d : direction) {
                int dx = d[0];
                int dy = d[1];
                if (dx < 0 || dy < 0 || dx >= m || dy >= n || visited[dx][dy] || grid[dx][dy] == 0) { 
                    continue;
                }
                q.add(d);
                visited[dx][dy] = true;
            }
        }
        return currArea;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int currMax = 0;
        int maxRows = grid.length;
        int maxCols = grid[0].length;
        visited = new boolean[maxRows][maxCols];

        for (int r = 0; r < maxRows; r++) {
            for (int c = 0; c < maxCols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int islandArea = bfs(grid, r, c);
                    currMax = Math.max(currMax, islandArea);
                }
            }
        }
        return currMax;
    }
}
