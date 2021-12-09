public class MaxIncreaseOfSkyline {

    public static int maxIncrease(int[][] grid){

        int n = grid.length;
        int[] max_row_value = new int[n];
        int[] max_column_value = new int[n];
        int result = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                max_row_value[i] = Math.max(max_row_value[i], grid[i][j]);
                max_column_value[j] = Math.max(max_column_value[j], grid[i][j]);

            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                result += Math.min(max_row_value[i], max_column_value[j]) - grid[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(maxIncrease(grid));
    }
}
