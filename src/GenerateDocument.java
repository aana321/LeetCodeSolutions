import java.util.HashMap;

public class GenerateDocument {

    public static boolean generateDocument(String characters, String document){
        HashMap<Character,Integer> characterCounts = new HashMap<>();
        for(int i=0; i<characters.length(); i++){
            char character = characters.charAt(i);
            characterCounts.put(character,characterCounts.getOrDefault(character, 0) + 1);
        }
        for(int i=0; i<document.length(); i++){
            char character = document.charAt(i);
            if(!characterCounts.containsKey(character) || characterCounts.get(character) == 0){
                return false;
            }

            characterCounts.put(character,characterCounts.get(character) - 1);
        }

        return true;

    }

    public static void main(String[] args){
        String characters = "Alog si eht Btse !";
        String document = "Algo is the Best !";
        System.out.println(generateDocument(characters, document));

    }
}
