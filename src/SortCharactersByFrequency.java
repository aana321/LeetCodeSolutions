import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    /** You have given a string s = "tree". you need to sort the string by the frequency of its character
     * occurrence s = eetr;
     *
     * Algorithm : 1- Declare a Hashmap to calculate the frquency of each character
     * 2- Throw all the characters in the maxHeap to with top frequecy character at the top of heap, the max heap will
     * have a constructor with lambda functions telling how to compare the characters based on their frequency in ehap
     * 3- Build a string from the heap to get the final result
     * */

    public static String frequencySort(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        maxHeap.addAll(map.keySet());
        StringBuilder result = new StringBuilder();
        while(!maxHeap.isEmpty()){
            char current = maxHeap.remove();
            for(int i=0; i<map.get(current); i++){
                result.append(current);
            }
        }

        return result.toString();
    }
}
