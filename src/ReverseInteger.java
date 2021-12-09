public class ReverseInteger {

    public static int reverseInt(int x){
        if(x==0){
            return 0;
        }
        int pop;
        int reveredInteger = 0;
        while(x != 0){
            pop = x % 10;
            x /= 10;

            if(reveredInteger > Integer.MAX_VALUE/10 || reveredInteger == Integer.MAX_VALUE/10 && pop == 7){
                return 0;
            }
            if(reveredInteger < Integer.MIN_VALUE/10 || reveredInteger == Integer.MIN_VALUE/10 && pop == -8){
                return 0;
            }

            reveredInteger = (reveredInteger * 10) + pop;

        }

        return reveredInteger;
    }
}
