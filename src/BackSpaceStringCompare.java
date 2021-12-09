import java.util.Stack;

public class BackSpaceStringCompare {

    public static boolean isBackSpaceStringEquals(String S, String T){
        Stack<Character> sStack = new Stack<>();
        for(char c : S.toCharArray()){
            if(c != '#'){
                sStack.push(c);
            }else if(!sStack.isEmpty()){
                sStack.pop();
            }
         }

        Stack<Character> tStack = new Stack<>();
        for(char c : T.toCharArray()){
            if(c!= '#'){
                tStack.push(c);
            }else if(!tStack.isEmpty()){
                tStack.pop();
            }
        }

        while(sStack.isEmpty()){
            char currentChar = sStack.peek();
            if(!tStack.isEmpty() && tStack.peek() != currentChar){
                return false;
            }

        }


        return sStack.isEmpty() && tStack.isEmpty();
    }
}
