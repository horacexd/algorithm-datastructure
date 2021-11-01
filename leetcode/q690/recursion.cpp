#include <iostream>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int getImportance(vector<Employee*> employees, int id) {
        unordered_map<int, Employee*> graph;
        for (auto e : employees) {
            // graph.insert(make_pair(e->id, e));
            graph[e->id] = e;
        }
        return getImportance(id, graph);
    }
    
private:
    int getImportance(int lead, const unordered_map<int, Employee*>& graph) {
        int cur = graph.at(lead)->importance;
        for (auto sub : graph.at(lead)->subordinates) {
            cur += getImportance(sub, graph);
        }
        return cur;
    }
};

class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};