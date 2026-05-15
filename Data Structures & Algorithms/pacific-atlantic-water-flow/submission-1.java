class Solution {
    int rows;
    int cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;

        // visited arrays
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific Ocean
        // top row
        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c, heights[0][c]);
        }

        // left column
        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, r, 0, heights[r][0]);
        }

        // Atlantic Ocean
        // bottom row
        for (int c = 0; c < cols; c++) {
            dfs(heights, atlantic, rows - 1, c,
                heights[rows - 1][c]);
        }

        // right column
        for (int r = 0; r < rows; r++) {
            dfs(heights, atlantic, r, cols - 1,
                heights[r][cols - 1]);
        }

        List<List<Integer>> res = new ArrayList<>();

        // cells reachable by both oceans
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (pacific[r][c] && atlantic[r][c]) {

                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    public void dfs(int[][] heights,
                    boolean[][] visited,
                    int r,
                    int c,
                    int prevHeight) {

        // boundary check
        if (r < 0 || c < 0 ||
            r >= rows || c >= cols) {

            return;
        }

        // already visited
        if (visited[r][c]) {
            return;
        }

        // reverse flow condition
        if (heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        dfs(heights, visited, r + 1, c, heights[r][c]);
        dfs(heights, visited, r - 1, c, heights[r][c]);
        dfs(heights, visited, r, c + 1, heights[r][c]);
        dfs(heights, visited, r, c - 1, heights[r][c]);
    }
}
