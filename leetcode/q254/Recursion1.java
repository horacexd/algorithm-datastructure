package leetcode.q254;

import java.util.List;
import java.util.ArrayList;

/*
 input:
 output:

    1. sorted?
    1.1 should group also be sorted?
    1.2 result sorted by group? the first value?
    
    2. return is number or all the result

    3. duplicate
        2 2 3 and 3 2 2 is same or not
    
*/

public class Recursion1 {
    
    public List<List<Integer>> getFactors(int n) {
        if (n <= 1) {
            return new ArrayList<>(); 
        }
        List<List<Integer>> result = new ArrayList<>();
        getFactors(n, 2, new ArrayList<>(), result);
        result.remove(result.size() - 1);
        return result;
    }

    private void getFactors(int remaining, int prev, List<Integer> path, List<List<Integer>> result) {
        if (remaining == 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = prev; i <= remaining; i++) {
            if (remaining % i == 0) {
                path.add(i);
                getFactors(remaining / i, i, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Recursion1 r = new Recursion1();
        System.out.println(r.getFactors(12));
    }
}
