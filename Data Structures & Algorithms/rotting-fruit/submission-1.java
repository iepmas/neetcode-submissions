class Solution {
    Queue<int[]> q = new LinkedList<>();
    boolean[][] visited;
    int count = 0;
    int remaining = 0;
    int time = 0;

    private boolean isValidCell(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length) {
            return false;
        }

        if (y < 0 || y >= grid[0].length) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        if (grid[x][y] != 1) {
            return false;
        }

        return true;
    }

    private void bfs(int[][] grid, int m, int n) {
        
        while (!q.isEmpty() && remaining > 0) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                int[] coords = q.poll();
                int x = coords[0];
                int y = coords[1];

                int[] up = new int[]{x, y-1};
                int[] down = new int[]{x, y+1};
                int[] left = new int[]{x-1, y};
                int[] right = new int[]{x+1, y};
                int[][] directions = new int[][]{up, down, left, right};

                for (int[] d : directions) {
                    int dx = d[0];
                    int dy = d[1];

                    if (!isValidCell(grid, dx, dy)) {
                        continue;
                    }

                    visited[dx][dy] = true;
                    q.offer(d);
                    remaining--;
                }
            }
            time++;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    remaining++;
                } else if (grid[r][c] == 2) {
                    q.offer(new int[]{r,c});
                }
            }
        }

        bfs(grid, m, n);
        
        return remaining == 0 ? time : -1;
    }
}
