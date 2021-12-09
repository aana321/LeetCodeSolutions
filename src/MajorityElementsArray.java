import java.util.HashMap;

public class MajorityElementsArray {
    public static int majorityElements(int[] A){
        if(A.length == 1){
            return A[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer i : A){
            if(map.containsKey(i) && map.get(i) + 1 > A.length / 2){
                return  i;
            }else{
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }
        return -1;
    }
}
