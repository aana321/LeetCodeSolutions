import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReverseWord {

    public static String reverseWordInString(String s){
        List<String> words = new ArrayList<>();
        int startWord = 0;

        for(int i=0; i<s.length(); i++){
            char character = s.charAt(i);
            if(character == ' '){
                words.add(s.substring(startWord, i));
                startWord = i;
            }else if(s.charAt(startWord) == ' '){
                words.add(" ");
                startWord = i;

            }
        }

        words.add(s.substring(startWord));
        Collections.reverse(words);

        return  String.join("", words);

    }

    public static void main(String[] args){
        String s = "My name is Vania Mishra";
        System.out.println(reverseWordInString(s));
    }
}
