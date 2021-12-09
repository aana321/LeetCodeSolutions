public class NumberOfIsland {
    /** You have given a grid of length m*n, The island is represented by 1 with connecting neighbors as 1 and 0 as
     * water. You need to calculate the total number of island that grid contains.
     * **/

    public static int totalNumberOfIsland(char[][] grid){
        int numOfIsland = 0;
        if(grid == null || grid.length == 0){
            return 0;
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == '1'){
                    numOfIsland += dfs(grid, i, j);
                }
            }
        }

        return numOfIsland;
    }

    private static int dfs(char[][] grid, int i, int j) {
        if(i<0 || i>= grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0'){
            return 0;
        }
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);

        return 1;
    }
}
