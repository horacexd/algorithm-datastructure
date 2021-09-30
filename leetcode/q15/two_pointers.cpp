#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {

public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> v;
        if (nums.size() < 3) {
            return v;
        }
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size() - 2; i++) {
            while (i > 0 && i < nums.size() && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i >= nums.size() - 2) {
                break;
            }
            int j = i + 1, k = nums.size() - 1;
            while (j < k) {
                if (nums[j] + nums[k] == -nums[i]) {
                    v.push_back({nums[i], nums[j], nums[k]});
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                } else if (nums[j] + nums[k] < -nums[i]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return v;
    }
};

int main() {

    return 0;
}