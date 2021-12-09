public class MaxConsecutiveOnes {

    public static int maxOnes(int[] A, int K){
        int i =0;
        int j =0;

        while(i<A.length){
            if(A[i] == 0){
                K--;
            }
            if(K<0){
                if(A[j] == 0){
                    K++;
                }
                j++;
            }

            i++;
        }

        return i-j;

    }
}
