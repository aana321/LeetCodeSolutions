import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    /**
     * Given a string containing digits from 2-9 inclusive,
     * return all possible letter combinations that the number could represent. Return the answer in any order.
     *
     * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     * Example 1:
     * Input:	digits = "23"
     * Output:	["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * Example 2:
     * Input:	digits = ""
     * Output:	[]
     * Example 3:
     * Input:	digits = "2"
     * Output:	["a","b","c"]
     *
     * ------------Algorithm--------------
     * 1- Classic BFS problem where each digit is associated with different letter in phone numbers
     * 2- We can treat the root as digit and letters as their branches and will lookup with each next digit combination recursively
     * 3- Store all the digit letter mappings to any aux space say array of strings for O(1) lookup
     * 4- Call the recursive function to retrieve the results
     * */

    public static List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();
        if(digits.length() ==0 || digits == null) return result;
        String[] mapping = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        letterCombinationsRecursive(result,digits, "", 0, mapping);
        return result;

    }

    private static void letterCombinationsRecursive(List<String> result, String digits, String current, int index, String[] mapping) {

        if(index == digits.length()){
            result.add(current);
            return;
        }

        String letter = mapping[digits.charAt(index) - '0'];
        for(int i = 0; i<letter.length(); i++){
            letterCombinationsRecursive(result, digits, current + letter.charAt(i), index+1, mapping);
        }

    }

    public static void main(String[] args){
        String digits = "123";
        System.out.println(letterCombinations(digits));
    }

}
