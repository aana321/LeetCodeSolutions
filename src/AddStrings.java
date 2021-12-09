public class AddStrings {
    public static String addString(String num1, String num2){
        String ans = "";
        int carry = 0;
        int i = num1.length() -1;
        int j = num2.length() -1;

        while(i>=0 && j>=0){
            int res = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
            carry = res/10;
            ans = res%10 + ans;
            i--;
            j--;
         }

        while(i>=0){
            int res = num1.charAt(i) - '0' + carry;
            carry = res/10;
            ans = res%10 + ans;
            i--;
         }
        while(j>=0){
            int res = num1.charAt(j) - '0' + carry;
            carry = res/10;
            ans = res%10 + ans;
            j--;
         }

        System.out.println(ans);
        if(carry>0) ans = ans + carry;

        return ans;
    }

    public static void main(String[] args){
        String num1 = "124344";
        String num2 = "11111";

        System.out.println(addString(num1, num2));
    }
}
