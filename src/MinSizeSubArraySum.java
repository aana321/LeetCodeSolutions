public class MinSizeSubArraySum {

    public static int minSubArraySum(int s, int[] a){
        int result = Integer.MAX_VALUE;
        int left = 0;
        int val_sum = 0;
        for(int i = 0; i<a.length; i++){
            val_sum += a[i];
            while(val_sum >=s){
                result = Math.min(result, i+1 - left);
                val_sum -= a[left];
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        int s =7;
        System.out.println(minSubArraySum(7,nums));
    }
}
