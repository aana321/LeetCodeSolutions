public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums){
        int current = 0;
        int next = 1;
        while(next<nums.length){
            if(nums[current] == nums[next]){
                next++;
            }else{
                nums[++current] = nums[next];
            }

        }
        return current + 1;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,5,6,7,7};
        System.out.println(removeDuplicates(nums));
    }
}
