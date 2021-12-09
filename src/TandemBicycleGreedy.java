import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TandemBicycleGreedy {

    public static int speedOfTandemBiCycle(int[] redShirtRider, int[]  blueShirtRider, boolean fastest){
        int totalSpeed = 0;
        Arrays.sort(redShirtRider);
        Arrays.sort(blueShirtRider);
        if(!fastest){
            reverseArraysInPlace(redShirtRider);
            for(int i=0; i<redShirtRider.length; i++){
                int rider1 = redShirtRider[i];
                int rider2 = blueShirtRider[blueShirtRider.length - i - 1];

                totalSpeed += Math.max(rider1, rider2);

            }
        }

        return totalSpeed;

    }

    private static void reverseArraysInPlace(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while(start<end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start += 1;
            end -= 1;

        }

    }
}
