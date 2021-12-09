

public class LongestRepeatingCharacters {
    /* You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

    Return the length of the longest substring containing the same letter you can get after performing the above operations.**/


    public static int longestRepeatingCharacters(String s, int K){
        int n = s.length();
        int[] char_counts = new int[26];
        int window_start = 0;
        int max_count = 0;
        int max_length = 0;

        for(int window_end =0; window_end<s.length(); window_end++ ){

            int current_char_counts = char_counts[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count, current_char_counts);

            while(window_start - window_end - max_count + 1 > K){
                char_counts[s.charAt(window_start) - 'A']--;
                window_start++;
            }

            max_length = Math.max(max_length,window_start - window_end + 1);

        }



        return max_length;
    }
}
