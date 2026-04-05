class Solution {

    public static int xDir[] = {-1, 0, 1, 0};
    public static int yDir[] = {0, 1, 0, -1};

    public int numIslands(char[][] grid) {

        if(grid == null ||  grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean visited[][] = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, visited, grid, rows, cols);
                    count++;
                } 
            }
        }

        return count;
    }

    public void dfs(int r, int c, boolean[][] visited, char[][] grid, int rows, int cols) {
        visited[r][c] = true;

        for(int k=0; k<4; k++) {
            int nr = r + xDir[k];
            int nc = c + yDir[k];

            if(!isValid(nr, nc, rows, cols))
                continue;
            
            if(grid[nr][nc] == '1' && !visited[nr][nc]) {
                dfs(nr, nc, visited, grid, rows, cols);
            }

        }
    }

    public boolean isValid(int r, int c, int rows, int cols) {
        if(r>=0 && r<rows && c>=0 && c<cols)
            return true;
        return false;
    }

}
