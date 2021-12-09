import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> generateAnagrams(List<String> words){
        Map<String, List<String>> anagrams = new HashMap<>();
        for(String word : words){
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            if(anagrams.containsKey(sortedWord)){
                anagrams.get(sortedWord).add(word);
            }else{
                anagrams.put(sortedWord, new ArrayList<>(Arrays.asList(word)));
            }

        }

        return new ArrayList<>(anagrams.values());
    }
}
