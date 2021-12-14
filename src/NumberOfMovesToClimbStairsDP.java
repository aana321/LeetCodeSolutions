public class NumberOfMovesToClimbStairsDP {
    /**
     * You are climbing stairs. You can advance 1 to k steps at a time. Your destination is
     * exactly n steps up.
     * Write a program which takes as inputs n and k and returns the number of ways in which you can get to your destination.
     * For example, if n = 4 and k = 2, there are five ways in which to get to the destination:
     * • four single stair advances,
     * • two single stair advances followed by a double stair advance,
     * • a single stair advance followed by a double stair advance followed by a single
     * stair advance,
     * • a double stair advance followed by two single stairs advances, and • two double stair advances.
     *
     * _____________________Algo____________________
     * Since the first advance can be one step,two steps,...,ksteps,andallof theselead to different ways to get to the top,
     * we can write the following equation for the number of steps F(n,k):
     * k
     * For the working example, F( 4, 2) = F(4 - 2, 2) + F(4 - 1, 2). Recursing, F(4 - 2, 2) = F(4- 2- 2,2) + F(4- 2- 1,2).
     * Both F(0,2) and F(l,2) are base-cases, with a value of 1, so F(4- 2, 2) = 2.
     * Continuing with F(4- 1, 2), F(4- 1, 2) = F(4- 1- 2, 2) + F(4- 1- 1, 2).
     * The first term is a base-case, with a value of 1. The second term has already been computed—its value is 2.
     * Therefore, F(4 —1, 2) = 3, and F(4, 2) = 3 + 2.
     * In the program below, we cache values of F(i,k), 0 < i < n to improve time complexity.
     *
     * Time Complexity is O(nk) and space is O(n)
     * */

    public static int maxNumberOfWaysToTop(int top, int maxSteps){
        return computeMaxStepsToReachTop(top, maxSteps, new int[top+1]);
    }

    private static int computeMaxStepsToReachTop(int n, int maxSteps, int[] numberOfWaysToTop) {
        if(n <=1){
            return 1;
        }
        if(numberOfWaysToTop[n] == 0){
            for(int i=1; i< maxSteps && n-1 >=0; i++){
                numberOfWaysToTop[n] += computeMaxStepsToReachTop(n-i, maxSteps, numberOfWaysToTop);
            }

        }

            return numberOfWaysToTop[n];
    }

}
