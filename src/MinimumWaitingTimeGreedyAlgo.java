/* You are given an non empty array of positive integer representing the amount of time that queries would take
to execute. Only one query can be executed at a time and it can be executed in any order. A query's waiting time can
be defined as the amount of time it needs to wait till the last query gets executed.

Algorithm: We could apply greedy algorithm and find out the best index to begin with.
1- Sort the array
2 - Define the variable called total waiting time
3- Iterate through the array
4- Update the total time with the duration for previous executed query

Time Complexity - O(nlogn) , Space - O(1)
* */

import java.util.Arrays;

public class MinimumWaitingTimeGreedyAlgo {

    public int minWaitingTime(int[] queries){
        Arrays.sort(queries);
        int totalWaitingTime = 0;
        for(int i=0; i<queries.length; i++){
            int duration = queries[i];
            int queriesLeft = queries.length - (i+1);
            totalWaitingTime += duration * queriesLeft;
        }

        return totalWaitingTime;
    }

    public static void main(String[] args){
        int[] queries = {3,2,1,2,6};
        MinimumWaitingTimeGreedyAlgo minimumWaitingTimeGreedyAlgo = new MinimumWaitingTimeGreedyAlgo();
        System.out.println(minimumWaitingTimeGreedyAlgo.minWaitingTime(queries));
    }

}
