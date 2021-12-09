import java.util.HashSet;

public class RottingOrangeBFS {
    /**
     * You are given an m x n grid where each cell can have one of three values:
     *
     * 0 representing an empty cell,
     * 1 representing a fresh orange, or
     * 2 representing a rotten orange.
     * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
     *
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
     * Example 1:
     *
     *
     * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
     * Output: 4
     * **/

    public static int rottingOranges(int[][] grid){
        HashSet<String> rotten = new HashSet<>();
        HashSet<String> fresh = new HashSet<>();
        for(int i=0; i< grid.length; i++){
            for(int j =0; j< grid[i].length; j++){
                if(grid[i][j] == 1){
                    fresh.add("" + i + j);
                }else{
                    rotten.add("" + i + j);
                }
            }
        }

        int minutes = 0;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        while(fresh.size() > 0){
            HashSet<String> infected = new HashSet<>();
            for(String s : rotten){

                int i = s.charAt(0) - '0';
                int j = s.charAt(1) - '0';
                for(int[] direction : directions){
                    int nextI = direction[0];
                    int nextJ = direction[1];
                    if(fresh.contains(""+ nextI+ nextJ)){
                        fresh.remove("" + nextI + nextJ);
                        infected.add(""+  nextI+ nextJ);
                    }


                }
                if(infected.size() ==0){
                    return -1;
                }
                rotten = infected;
                minutes++;
            }
        }

        return minutes;
    }

    public static void main(String[] args){
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(rottingOranges(grid));
    }
}
