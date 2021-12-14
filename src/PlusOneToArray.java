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

        int[] result = new int[digits.length + 1]; // If the digit is 999 or 99 then we need to increase the length by 1 and return the result
        result[0] = 1;
        return result;
    }

    public static void main(String[] args){
        int[] digits = {9,9,9};
        plusOne(digits);
        for(int i=0; i<digits.length; i++){
            System.out.print(plusOne(digits).toString());
        }
    }
}
