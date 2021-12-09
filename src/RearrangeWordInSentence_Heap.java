import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeWordInSentence_Heap {

    public class Word{
        int index;
        String word;
        int length;

        public Word(int index, String word){
            this.index = index ;
            this.word = word;
            this.length = word.length();

        }

        Comparator<Word> comp = new Comparator<Word>() {
            @Override
            public int compare(Word w1, Word w2) {
                if(w1.length == w2.length) return w1.index - w2.index;
                return w1.length - w2.length ;
            }
        };

        public  String rearrangeWord(String text){
            Queue<Word> pq = new PriorityQueue<>(comp);
            String[] words = text.toLowerCase(Locale.ROOT).split(" ");
            for(int i=0; i<words.length; i++){
                String word = words[i];
                pq.offer(new Word(i,word));
            }
            StringBuilder sb = new StringBuilder();
            while(pq.size() >0){
               String word = pq.poll().word;
               sb.append(" "+word);
            }
            String res = sb.substring(1);
            return res.substring(0,1).toUpperCase() + res.substring(1);
        }

    }
}
