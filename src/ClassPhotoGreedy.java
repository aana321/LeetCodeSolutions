import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassPhotoGreedy {

    public static boolean isClassPhotoPossible(ArrayList<Integer> redShirtStudents, ArrayList<Integer> blueShirtStudents){
        Collections.sort(redShirtStudents, Collections.reverseOrder());
        Collections.sort(blueShirtStudents, Collections.reverseOrder());
        String shirtColorInFirstRow = "";
        if(redShirtStudents.get(0) < blueShirtStudents.get(0)){
             shirtColorInFirstRow = "RED";
        }else{
            shirtColorInFirstRow = "BLUE";
        }
        for(int i=0; i<redShirtStudents.size(); i++){
            int redShirtStudentHeight = redShirtStudents.get(i);
            int blueShirtStudentHeight = blueShirtStudents.get(i);

            if(shirtColorInFirstRow == "RED") {
                if (redShirtStudentHeight >= blueShirtStudentHeight) {
                    return false;
                }
            }else {
                    if(blueShirtStudentHeight >= redShirtStudentHeight){
                        return false;
                }
                }
         }
         return true;
    }
}
