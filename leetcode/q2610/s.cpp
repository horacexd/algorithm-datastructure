#include <iostream>
#include <vector>
#include <map>

using namespace std;

void printNestedVector(vector<vector<int>>); 

class Solution {

public:
    vector<vector<int>> findMatrix(vector<int>& nums) {
        map<int ,int> m;
        for (int n : nums) {
            if (m.count(n) == 0) {
                m[n] = 1;
            } else {
                m[n]++;
            }
        }

        vector<vector<int>> result;
        for (auto it = m.begin(); it != m.end(); it++) {
            int k = it->first;
            int v = it->second;
            for (int i = 0; i < v; i++) {
                if (i >= result.size()) {
                    result.push_back({});
                }
                result[i].push_back(k);
            }
        }
        return result;
    }
};

int main(int argc, char** argv) {
    Solution s;
    vector<vector<int>> vs = {
        {1, 3, 4, 5, 1, 3, 1},
        {5, 5, 5, 3, 3, 3, 1}
    };

    for (auto v : vs) {
        printNestedVector(s.findMatrix(v));
    }

    return 0;
}

void printNestedVector(vector<vector<int>> input) {
    string res;
    res += "{";
    for (auto out : input) {
        res += "[";
        for (int i = 0; i < out.size(); i++) {
            if (i != 0) {
                res += ",";
            }
            res += to_string(out[i]);
        }
        res += "]";
    }
    res += "}";

    cout << res << endl;
}

 /*
    basic idea:
    use countMap find the max counter 
    the max counter is the minimal row of the result
    map<key=num, val=count>
    for each kv pair:
        for each v:
            if row not exit
                create row
            add k to row
    
*/