import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {

    public static List<Integer[]> threeUniqueSum(int [] nums, int target){
        Arrays.sort(nums);
        List<Integer[]> result = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i<n-2; i++){

            int left = i + 1;
            int right = n - 1;
            while(left < right){
                int current_sum = nums[i] + nums[left] + nums[left];
                if(current_sum == target){
                    left++;
                    right--;
                    Integer[] newTriplet = {nums[i], nums[left], nums[right]};
                    result.add(newTriplet);
                }
                else if(current_sum < target){
                    left++;
                }
                else if(current_sum > target){
                    right--;
                }
            }

        }

        return result;

    }

    public static void main(String[] args){
        int[] nums = {12,3,1,2,-6,5,8,6};

        System.out.println("Unique Triplet for target Sums are  "  + threeUniqueSum(nums, 0));
    }
}
