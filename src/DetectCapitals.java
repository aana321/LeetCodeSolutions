public class DetectCapitals {
    /**We define the usage of capitals in a word to be right when one of the following cases holds:

     All letters in this word are capitals, like "USA".
     All letters in this word are not capitals, like "leetcode".
     Only the first letter in this word is capital, like "Google".
     Given a string word, return true if the usage of capitals in it is right.



     Example 1:

     Input: word = "USA"
     Output: true
     * */

    public static boolean detectCapital(String s){
        if(s.length() == 0 || s == null) return false;
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(Character.isUpperCase(s.charAt(i))){
                count++;
            }
        }

        return count == s.length() || count == 0 || count == 1 && Character.isUpperCase(s.charAt(0));
    }
}
