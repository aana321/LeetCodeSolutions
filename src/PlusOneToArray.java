public class PlusOneToArray {
    public static int[] plusOne(int[] digits){

        //Traverse the array from the end and add the 1 by incrementing the index if last element is not 9

        for(int i=digits.length -1; i>=0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args){
        int[] digits = {1,3,5};
        plusOne(digits);
        for(int i=0; i<digits.length; i++){
            System.out.print(digits[i]);
        }
    }
}
