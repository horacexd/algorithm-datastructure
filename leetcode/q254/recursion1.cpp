#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> getFactors(int n) {
        vector<vector<int>> result;

        vector<int> path;
        getFactors(n, 2, path, result);
        result.pop_back();
        return result;
    }

private:
    void getFactors(int remaining, int prev, vector<int>& path, vector<vector<int>>& result) {
        if (remaining == 1) {
            result.push_back(path);
            return;
        }

        for (int i = prev; i <= remaining; i++) {
            if (remaining % i == 0) {
                path.push_back(i);
                getFactors(remaining / i, i, path, result);
                path.pop_back();
            }
        }
    }
};