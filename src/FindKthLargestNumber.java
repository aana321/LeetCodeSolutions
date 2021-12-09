import java.util.PriorityQueue;

public class FindKthLargestNumber {
    public static int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> minHeaps = new PriorityQueue<>();
        for(int i : nums){
            minHeaps.add(i);
            if(minHeaps.size() > k){
                minHeaps.remove();
            }
        }
        return minHeaps.remove();
    }
}
