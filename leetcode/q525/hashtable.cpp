#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        unordered_map<int, int> umap;
        umap.insert({0, -1});
        int preSum = 0;
        int globalMax = 0;
        for (int i = 0; i < nums.size(); i++) { // vector.size()
            if (nums[i] == 0) {
                preSum -= 1;
            } else {
                preSum += 1;
            }
            if (umap.count(preSum) != 0) {
                globalMax = max(globalMax, i - umap.at(preSum));
            } else {
                umap.insert({preSum, i});
            }
        }
        return globalMax;
    }
};