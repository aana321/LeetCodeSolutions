public class ClimbingStairs {

    public static int minCost(int[] cost){
        int step1 = 0;
        int step2 = 0;
        for(int i=cost.length -1; i>=0; i--){
            int current_step = cost[i] + Math.min(step1, step2);
            step1 = step2;
            step2 = current_step;
        }

        return Math.min(step1, step2);
    }

    public static void main(String[] args){
        int[] cost = {10,15,20};
        System.out.println(minCost(cost));
    }
}
