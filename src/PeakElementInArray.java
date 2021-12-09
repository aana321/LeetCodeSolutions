public class PeakElementInArray {
    /** Given an array of length n, you need to find the peak element in the array which statisfy
     * the condition that element should be greater than its neighboring elements before and
     * after. There could be multiple peaks in the array
     * *
     * */

    public static int findPeak(int[] nums){
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args){
        int[] nums = {1,2,1,3,4,6,5};
        System.out.println(findPeak(nums));
    }
}
