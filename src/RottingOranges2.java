import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RottingOranges2 {
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<AbstractMap.SimpleImmutableEntry<Integer, Integer>> affected =
                new HashSet<AbstractMap.SimpleImmutableEntry<Integer, Integer>>();
        Set<AbstractMap.SimpleImmutableEntry<Integer, Integer>> fresh =
                new HashSet<AbstractMap.SimpleImmutableEntry<Integer, Integer>>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fresh.add(new AbstractMap.SimpleImmutableEntry<Integer, Integer>(i, j));
                } else if (grid[i][j] == 2) {
                    affected.add(new AbstractMap.SimpleImmutableEntry<Integer, Integer>(i, j));
                }
            }
        }

        int minutes = 0;
        Set<AbstractMap.SimpleImmutableEntry<Integer, Integer>> newAffected =
                new HashSet<AbstractMap.SimpleImmutableEntry<Integer, Integer>>();
        while (affected.size() > 0) {
            minutes++;
            Iterator<AbstractMap.SimpleImmutableEntry<Integer, Integer>> it = affected.iterator();
            while (it.hasNext()) {
                AbstractMap.SimpleImmutableEntry<Integer, Integer> entry = it.next();
                int i = entry.getKey();
                int j = entry.getValue();
                testOrange(fresh, newAffected, grid, i-1, j, n, m);
                testOrange(fresh, newAffected, grid, i+1, j, n, m);
                testOrange(fresh, newAffected, grid, i, j-1, n, m);
                testOrange(fresh, newAffected, grid, i, j+1, n, m);
            }

            affected.clear();
            Set<AbstractMap.SimpleImmutableEntry<Integer, Integer>> temp = affected;
            affected = newAffected;
            newAffected = temp;
        }

        if (fresh.size() == 0) {
            return minutes == 0 ? 0 : minutes - 1;
        }

        return -1;
    }

    public static void testOrange(
            Set<AbstractMap.SimpleImmutableEntry<Integer, Integer>> fresh,
            Set<AbstractMap.SimpleImmutableEntry<Integer, Integer>> newAffected,
            int[][] grid, int i, int j, int n, int m) {
        if (i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 1) {
            grid[i][j] = 2;
            AbstractMap.SimpleImmutableEntry<Integer, Integer> newEntry =
                    new AbstractMap.SimpleImmutableEntry<Integer, Integer>(i, j);
            newAffected.add(newEntry);
            fresh.remove(newEntry);
        }
    }

    public static void main(String[] args){
        int[][] grid = {};
    }

}
