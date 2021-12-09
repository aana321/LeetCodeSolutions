import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalanced(String s){
        String openingBraces = "([{";
        String closingBraces = ")]}";

        Map<Character,Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put('(', ')');
        matchingBrackets.put('[', ']');
        matchingBrackets.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
           char letter = s.charAt(i);
           if(openingBraces.indexOf(letter) !=-1){
                stack.push(s.charAt(i));
           }else{
               if(closingBraces.indexOf(letter)!=-1){
                   stack.pop();
               }
           }
        }
            return false;
    }
}
