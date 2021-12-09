public class LevenshteinDistanceDP {

    public static int levenshteinDistance(String s1, String s2){
        //Declare a DP 2D array of size s1.length + 1 as row and s.length + 1 as column
        int[][] minEdits = new int[s2.length() + 1][s1.length() + 1];
        //Initialise the minEdits array with the values of rows as # 0 , 1, 2.. and columns as i
        for(int i = 0; i< s2.length() + 1; i++){
            for(int j = 0; j<s1.length() + 1; j++){
                minEdits[i][j] = j;
            }
            minEdits[i][0] = i;
        }
        //Now we will fill up the minEdits array with formulae to calculate the min number of edits

        for(int i=1; i<s2.length()+1; i++){
            for(int j=1; j<s1.length()+1; j++){
                //If the characters are equal then the value would be same as diagonal value of previous edit
                if(s2.charAt(i-1) == s1.charAt(j-1)){
                    minEdits[i][j] = minEdits[i-1][j-1];
                }else{
                    minEdits[i][j] = 1 + Math.min(minEdits[i-1][j-1], Math.min(minEdits[i][j-1], minEdits[i-1][j]));
                }
            }
        }

        return minEdits[s2.length()][s1.length()];

    }

}
