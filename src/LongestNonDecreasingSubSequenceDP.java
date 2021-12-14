import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestNonDecreasingSubSequenceDP {
    /**
     * The problem of finding the longest nondecreasing subsequence in a sequence of inte¬ gers has implications to many disciplines,
     * including string matching and analyzing card games. As a concrete instance,
     * the length of a longest non decreasing subse¬ quence for the array in Figure 17.15 is 4.
     * There are multiple longest non decreasing subsequences,e.g.,(0,4,10,14}and(0,2,6,9).
     * Note that elements of non-decreasing subsequence are not required to immediately follow each other in the original se¬ quence.
     * 0 8 4 12 2 10 6 14 1 9 A[0] A[l] A[2] A[3] A[ 4] A[5] A[6] A[7] A[8] Al9]
     * Figure 17.15: An array whose longest nondecreasing subsequences are of length 4.
     * Write a program that takes as input an array of numbers and returns the length of a longest nondecreasing subsequence in the array.
     * _____________Algorithm________________
     * We can solve this problem using DP as to calculate the sub problem of the initial given sequence from the A[0:j]
     * We can calculate the running length of longest subsequence if A[i] <= A[i+1]
     * and found out the max length.
     * _____________Time Complexity___________
     * O(n*n) -- time
     * O(n) -- space
     * */

    public static int longestNonDecreasingSubsequence(List<Integer> A) {
        Integer[] maxSubsequenceLength = new Integer[A.size()];
        Arrays.fill(maxSubsequenceLength, 1);
        for(int i=1; i<A.size(); i++){
            for(int j =0; j< i; j++){
                if(A.get(i) >= A.get(j)){
                    maxSubsequenceLength[i] = Math.max(maxSubsequenceLength[i], maxSubsequenceLength[j] + 1);
                }
            }
        }

        return Collections.max(Arrays.asList(maxSubsequenceLength));
    }
}
