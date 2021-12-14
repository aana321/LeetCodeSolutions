import java.util.List;

public class PickCoinForMaxGainDP {
/**In the pick-up-coins game, an even number of coins are placed in a line, as in Fig¬ ure 17.11. Two players take turns at choosing one coin each—they can only choose from the two coins at the ends of the line. The game ends when all the coins have been picked up. The player whose coins have the higher total value wins. A player cannot pass his turn.
 Figure 17.11: A row of coins.
 Design an efficient algorithm for computing the maximum total value for the starting
 player in the pick-up-coins game.

 Algo:
 First of all, note that greedily selecting the maximum of the two end coins does not yield the best solution.
 If the coins are 5, 25,10,1, if the first player is greedy and chooses 5, the second player can pick up the 25.
 Now the first player will choose the 10, and the second player gets the 1, so the first player has a total of 15 and the second player has a total of 26.
 A better move for the first player is picking up 1. Now the second player is forced to expose the 25, so the first player will achieve 26.
 The drawback of greedy selection is that it does not consider the opportunities created for the second player.
 Intuitively, the first player wants to balance selecting high coins with minimizing the coins available to the second player.
 The second player is assumed to play the best move he possibly can.
 Therefore, the second player will choose the coin that maximizes his revenue.
 Call the sum of the coins selected by a player his revenue. Let R(a,b) be the maximum revenue a player
 can get when it is his turn to play, and the coins remaining on the table are at indices a to b, inclusive.
 Let C be an array representing the line of coins, i.e., C[i] is the value of the zth coin.
 If the first player selects the coin at a, since the second player plays optimally,
 the firstplayer will end up with a total revenue of C[a]+S(a+1, b)-R(a+1, b), where S(a,b) is the sum of the coins from positions a to b, inclusive.
 If he selects the coin at b, he will end up with a total revenue of C[b] + S(a,b - 1) - R(a,b - 1).
 Since the first player wants to maximize revenue, he chooses the greater of the two, i.e.,
 R(a,b) =max(C[a]+S(a+l,b)~ R(a+1,b),C[b]+S(a,b-1)- R(a,b-1)).
 Thisrecursion for R can be solved easily using DP.
 Now we present a slightly different recurrence for R.
 Since the second player seeks to maximize his revenue, and the total revenue is a constant, it is equivalent for the the second player to move so as to minimize the first player's revenue. Therefore, R(a, b) satisfies the following equations:
 R(a,b)
 / C[b]+min R(a+l,b-l),
 if a < b) otherwise.
 C[a]+min{ R(a+2,b),
 \
 , R(a+l,b-l) max '
 °,
 ) k R(a,b- 2)
 In essence, the strategy is to minimize the maximum revenue the opponent can gain.
 The benefit of this "min-max" recurrence for R(a,b),compared to our first formulation, is that it does not require computing S(a + 1, b) and S(a, b - 1).
 Forthecoins(10,25,5,1,10,5),theoptimumrevenueforthefirstplayeris31.
 Some of subproblems encountered include computing the optimum revenue for (10,25) (which is 25), (5,1) (which is 5), and (5,1,10,5) (which is 15).
 For the coins in Figure 17.11 on the facing page, the maximum revenue for the first player is 140tf, i.e., whatever strategy the second player uses, the first player can guarantee a revenue of at least 140tf.
 In contrast, if both players always pick the more valuable of the two coins available to them, the first player will get only 120tf.
 In the program below, we solve for R using DP.

 **************** Time Complexity ****************
 * There are 0(n2) possible arguments for R(a,b),
 * where n is the number of coins, and the time spent to compute R from previously computed values is 0(1).
 * Hence, R can be computed in 0(n2) time.
 * */

    public static int pickUpCoins(List<Integer> coins){

        return computeMaxRevenueForRange(coins, 0, coins.size() -1, new int[coins.size()][coins.size()]);

    }

    private static int computeMaxRevenueForRange(List<Integer> coins, int a, int b, int[][] maxRevenueForRange) {
        if(a>b) return 0; //No coins left

        if(maxRevenueForRange[a][b] == 0){
            int maxRevenueForA = coins.get(a) + Math.min(computeMaxRevenueForRange(coins, a+2, b, maxRevenueForRange),
                    computeMaxRevenueForRange(coins, a+1, b-1, maxRevenueForRange));

            int maxRevenueForB = coins.get(b) + Math.min(computeMaxRevenueForRange(coins, a, b-2, maxRevenueForRange)
            , computeMaxRevenueForRange(coins, a+1, b-1, maxRevenueForRange));

            maxRevenueForRange[a][b] = Math.max(maxRevenueForA, maxRevenueForB);
        }

        return maxRevenueForRange[a][b];

    }
}
