class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Put all treasure chests into queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                }
            }
        }
        // Possible directions 
        int[][] directions = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
        };

        // Multi-source BFS
        while (!q.isEmpty()) {

            int[] cell = q.poll();

            int r = cell[0];
            int c = cell[1];

            for (int[] d : directions) {

                int nr = r + d[0];
                int nc = c + d[1];

                // boundary check
                if (nr < 0 || nc < 0 ||
                    nr >= rows || nc >= cols) {
                    continue;
                }

                // only visit INF cells
                if (grid[nr][nc] != 2147483647) {
                    continue;
                }

                // distance update
                grid[nr][nc] = grid[r][c] + 1;

                q.offer(new int[]{nr, nc});
            }
        }
    }
}
