class Solution {
        public int numIslands(char[][] grid) {
        int numofIslands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (backTrackForIslands(row, col, grid)) {
                    numofIslands++;
                }
            }
        }
        return numofIslands;
    }

    private boolean backTrackForIslands(int row, int col, char[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != '1') {
            return false;
        }

        char currCharValue = grid[row][col];
        grid[row][col] = '0';
        backTrackForIslands(row + 1, col, grid);
        backTrackForIslands(row, col + 1, grid);
        backTrackForIslands(row - 1, col, grid);
        backTrackForIslands(row, col - 1, grid);

        return true;
    }

}
