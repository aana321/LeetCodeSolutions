public class LicenseKeyFormatting {
    /**You are given a license key represented as a string s that consists of only alphanumeric characters and dashes.
     * The string is separated into n + 1 groups by n dashes. You are also given an integer k.

     We want to reformat the string s such that each group contains exactly k characters, except for the first group,
     which could be shorter than k but still must contain at least one character.
     Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.
     Return the reformatted license key.

     Example 1:

     Input: s = "5F3Z-2e-9-w", k = 4
     Output: "5F3Z-2E9W"
     Explanation: The string s has been split into two parts, each part has 4 characters.
     Note that the two extra dashes are not needed and can be removed.

     _________________Algorithm__________________
     1- Given from the problem statement we could start iterating from the end of the String
     2- We should look for 3 valid condition for formatting the string
     3- We should ignore the '-' character until we group K characters together
     4- We should convert letter or number to uppercase until K characters are not grouped
     5- Add the character '-' once K characters are grouped
     * */

    public static String licenseFormatter(String S, int K){
        StringBuilder result = new StringBuilder();
        int count = 0;
        int i = S.length() - 1;

        if(S.length() == 0 || S == null) return "";
        while(i>=0){
            char current = Character.toUpperCase(S.charAt(i));
            if(current == '-'){
                i--;
            }else if(count !=0 && count % K == 0){
                result.insert(0, '-');
                count = 0;
            }else{
                result.insert(0, current);
                count++;
                i--;
            }
        }

        return result.toString();
    }

    public static void main(String[] args){
        String s = "5F3Z-2e-9-w";
        int K = 4;
        System.out.println("The formatted String is " + licenseFormatter(s,K));
    }
}
