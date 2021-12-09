import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class BuildingWithSunsetView {
    /**You are given with a series of buildings that have windows facing west.
     * The buildings are in a straight line, and any building which is to the east of a building of equal or greater height cannot view the sunset.
     Design an algorithm that processes buildings in east-to-west order and returns
     the set of buildings which view the sunset. Each building is specified by its height.
     *
     * Algorithm:: A brute-force approach is to store all buildings in an array.
     * We then do a reverse scan of this array, tracking the running maximum.
     * Any building whose height is less than or equal to the running maximum does not have a sunset view.
     * The time and space complexity are both 0(n), where n is the number of buildings.
     * Note that if a building is to the east of a taller building, it cannot view the sunset.
     * This suggests a way to reduce the space complexity. We record buildings which potentially have a view.
     * Each new building may block views from the existing set.
     * We determine which such buildings are blocked by comparing the new building's height to that of the buildings in the existing set.
     * We can store the existing set as a hash set—this requires us to iterate over all buildings each time a new building is processed.
     * If a new building is shorter than a building in the current set,
     * then all buildings in the current set which are further to the east cannot be blocked by the new building.
     * This suggests keeping the buildings in a last-in, first-out manner, so that we can terminate earlier.
     * Specifically, we use a stack to record buildings that have a view. Each time a building b is processed,
     * if it is taller than the building at the top of the stack, we pop the stack until the top of the stack is taller than
     * b—all the buildings thus removed lie to the east of a taller building.
     * Although some individual steps may require many pops, each building is pushed and popped at most once.
     * Therefore, the run time to process n buildings is 0(n), and the stack always holds precisely the buildings which currently have a view.
     * The memory used is 0(n), and the bound is tight,
     * even when only one building has a view—consider the input where the west-most building is the tallest,
     * and the remaining n —1 buildings decrease in height from east to west. However, in the best-case, e.g.,
     * when buildings appear in increasing height, we use 0(1) space. In contrast, the brute-force approach always uses 0(n) space.
    * **/

    public static class BuildingHeight{
       public Integer id;
       public Integer height;

        BuildingHeight(Integer id, Integer height){
            this.id = id;
            this.height = height;
        }
    };

    public static Deque<BuildingHeight> examineBuildingWithSunsetView(Iterator<Integer> sequence){
        int buildingIndex = 0;
        Deque<BuildingHeight> buildingWithSunset = new LinkedList<>();
        while(sequence.hasNext()){
            Integer buildingHeight = sequence.next();
            while(!buildingWithSunset.isEmpty() && Integer.compare(buildingHeight, buildingWithSunset.getLast().height) >=0){
                buildingWithSunset.removeLast();

            }
            buildingWithSunset.addLast(new BuildingHeight(buildingIndex++, buildingHeight));
        }

        return buildingWithSunset;
    }

}
