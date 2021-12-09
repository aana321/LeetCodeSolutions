import java.util.ArrayList;
import java.util.List;

public class ProductSum {

    public static int productSum(ArrayList<Object> nums){

        return productSumHelper(nums, 1);
    }

    public static int productSumHelper(ArrayList<Object> array, int multiplier){

        int sum = 0;
        for(Object el : array){
            if(el instanceof ArrayList){
                ArrayList<Object> ls = (ArrayList<Object>) el;
                sum += productSumHelper(ls, multiplier + 1);
            }else{
                sum += (int) el;
            }
        }

        return sum * multiplier;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Object>> ls = new ArrayList<>();

    }
}
