class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        int minutes = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        // Step 1: Find rotten oranges and count fresh ones
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // Step 2: BFS
        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            // One BFS level = one minute
            for (int k = 0; k < size; k++) {

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

                    // only fresh oranges
                    if (grid[nr][nc] != 1) {
                        continue;
                    }

                    // rot it
                    grid[nr][nc] = 2;

                    fresh--;

                    q.offer(new int[]{nr, nc});
                }
            }

            minutes++;
        }

        // if fresh still remains, impossible
        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}
