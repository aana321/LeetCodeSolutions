import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {
    /**
     * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
     *
     * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
     *
     * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
     * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
     * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
     * Given the integer array fruits, return the maximum number of fruits you can pick.
     *
     *
     *
     * Example 1:
     *
     * Input: fruits = [1,2,1]
     * Output: 3
     * Explanation: We can pick from all 3 trees.
     */

    public static int maxFruitsInBasket(int[] trees){
        if(trees.length == 0 || trees == null){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxFruits = 1;
        int i =0;
        int j = 0;
        while(j<trees.length){
            if(map.size() < 2){
                map.put(trees[j], j++);
            }
            if(map.size() > 2){
                int min = trees.length -1;
                for(int value : map.values()){
                    min = Math.min(min, value);
                }
                i = min + 1;
                map.remove(trees[min]);
            }

            maxFruits = Math.max(maxFruits, j -i);

        }


        return maxFruits;
    }
}
