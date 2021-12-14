import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    /**
     *
     You are playing the following Flip Game with your friend:
     Given a string that contains only these two characters: + and -,
     you and your friend take turns to flip two consecutive "++" into "–".
     The game ends when a person can no longer make a move and therefore the other person will be the winner.
     Write a function to compute all possible states of the string after one valid move.

     Input : String s = "++++"
     Output : [ "--++", "+--+", "++--"]

     --------------Algorithm-----------------
     1- Going through the string and finding every single place where we have 2 consecutive ++ signs.
     2- Flipping them to -- sign and count for next possible move by iterating it over next characters.
     3- Create a list of string called possibleStates
     4- initialize the index with start from i = 0 till length of string
     5- We also need to make sure when we iterate the string next time we shouldn't be counting the first occurrences of ++ signs we encountered
     6- So, we keep on updating the nextMoves
     7- If index can never find 2 consecutives ++ then nextMoves becomes -1 which means we should return empty list
     8- If not then we could make String of nextStates with possible moves and add it to our list of results.
     9

     ---------Time complexity would be O(n*n) due to substring call and space complexity is O(n)-----------------
     * */

    public static List<String> generatePossibleMoves(String s){
        List<String> possibleStates = new ArrayList<>();
        int i = 0;
        while(i< s.length()- 1){
            int nextMoves = i == 0 ? s.indexOf("++") : s.indexOf("++", i);
            if(nextMoves == -1){
                return possibleStates;
            }

            String nextStates = s.substring(0, nextMoves) + "--" + s.substring(nextMoves + 2);
            possibleStates.add(nextStates);
            i = nextMoves + 1;
        }

        return possibleStates;
    }

    public static void main(String[] args){
        String s = "++++";
        System.out.println(generatePossibleMoves(s));
    }
}
