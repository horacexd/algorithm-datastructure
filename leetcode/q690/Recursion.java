package leetcode.q690;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Recursion {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> graph = new HashMap<>();
        for (Employee e : employees) {
            graph.put(e.id, e);
        }
        
        return getImportance(id, graph);
    }
    
    private int getImportance(int root, Map<Integer, Employee> graph) {
        int cur = graph.get(root).importance;
        for (int sub : graph.get(root).subordinates) {
            cur += getImportance(sub, graph);
        }
        return cur;
    }

    static class  Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}