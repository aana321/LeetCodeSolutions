
public class MinRotationDominos {
    /**
     * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
     * We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
     *
     * Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
     *
     * If it cannot be done, return -1.
     * */

    public static int minRotation(int[] top, int[] bottom){
        int minSwaps = Integer.MAX_VALUE;
        for(int i=0; i< top.length; i++){
            minSwaps = Math.min(
                    numSwaps(top[0], top, bottom),
                    numSwaps(bottom[0], top, bottom)
            );

            minSwaps = Math.min(minSwaps, numSwaps(top[0], bottom, top));
            minSwaps = Math.min(minSwaps, numSwaps(bottom[0], bottom, top));
        }
        return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps;
    }

    private static int numSwaps(int target, int[] A, int[] B) {
        int numsSwaps = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] != target && B[i] != target){
                return Integer.MAX_VALUE;
            }else if(A[i] != target){
                numsSwaps++;
            }
        }
        return numsSwaps;
    }
}
