public class MaxAreaOfIslandDFS {
    /**
     * Calculate the maximum area of island in a given grid, where 1 represents the land and 0 represents water. The
     * island must be connected with its neighbour in all 4 directions i.e. left, right , up and down
     * */

    public static int maxAreaOfIsland(int[][] grid){
        int maxArea = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; i<grid[i].length; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if(i<0 || i<grid.length || j>0 || j>grid[i].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int count = 0;
        count += dfs(grid, i+1, j);
        count += dfs(grid, i-1, j);
        count += dfs(grid, i, j+1);
        count += dfs(grid, i, j-1);

        return count;


    }

}
