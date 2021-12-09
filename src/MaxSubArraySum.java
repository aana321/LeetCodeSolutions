public class MaxSubArraySum {

    public static int maxSubArraySum(int[] nums){
        int maxSoFar = nums[0];
        int maxEndingSum = nums[0];

        if(nums.length == 0){
            return  maxSoFar;
        }

        for(int i=1; i<nums.length; i++){

            maxEndingSum = Math.max(nums[i] ,maxEndingSum + nums[i]);

            maxSoFar = Math.max(maxSoFar, maxEndingSum);
        }

        return maxSoFar;

    }

    public static void main(String[] args){
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArraySum(nums));
    }
}
