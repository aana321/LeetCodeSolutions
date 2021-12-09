import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

    public static List<Integer> nextPermutation(List<Integer> prem){
        int k = prem.size() - 2;
        while(k>0 && prem.get(k) >= prem.get(k+1)){
            k--;
        }
        if(k == -1){
            return Collections.emptyList();
        }

        for(int i = prem.size() -1; i>k; i--){
            if(prem.get(i) > prem.get(k)){
                Collections.swap(prem, k, i);
                break;
            }
        }

        return prem;
    }

    public static void main(String[] args){
        List<Integer> p = new ArrayList<>();
        p.add(6);
        p.add(2);
        p.add(3);
        p.add(5);
        p.add(4);
        p.add(1);
        p.add(0);

        System.out.println(nextPermutation(p));
    }
}
