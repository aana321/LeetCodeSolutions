public class ShortestWayToFormStringFromSourceToTarget {

    /**The input of the problem is two strings: source and target. The expected output is the minimum number of subsequences of source to form the target.
     For example, we can have source as 'abcd’, and target as 'aabacb’.
     Then the output will be 4, as we need at least the following subsequences of the source to form the target: 'a’, 'ab’, 'ac’, and 'b’.
     * */

    public static int shortestWay(String source, String target){
        int minSubSequence = 0;
        String remaining = target;
        while(remaining.length()>0){
            StringBuilder sb = new StringBuilder();
            int i = 0;
            int j = 0;
            while(i< source.length() && j<remaining.length()){
                if(source.charAt(i++) == remaining.charAt(j)){
                    sb.append(remaining.charAt(j++));
                }

                if(sb.length() == 0){
                    return -1;
                }

                minSubSequence++;
                remaining = remaining.substring(remaining.length());
            }
        }


        return minSubSequence;
    }

    public static void main(String[] args){

        String source = "abcd";
        String target = "aabacb";
        System.out.println(shortestWay(source, target));

    }
}
