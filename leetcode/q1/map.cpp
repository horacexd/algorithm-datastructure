#include <vector>
#include <unordered_map>
#include <iostream>

using namespace std;

void printVector(vector<int>);

class Solution {

public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> m;
        for (int i = 0; i < nums.size(); i++) {
            int diff = target - nums[i];
            if (m.count(diff) != 0) {
                return {m[diff], i};
            } 
            m[nums[i]] = i;
        }
        return {};
    }
};

int main(int argc, char** argv) {
    Solution s;
    vector<int> v1 = {2, 7, 11, 15};
    printVector(s.twoSum(v1, 9));

    vector<int> v2 = {3, 2, 4};
    printVector(s.twoSum(v2, 6));

    vector<int> v3 = {5, 3, 7, 2, 4};
    printVector(s.twoSum(v3, 11));
    printVector(s.twoSum(v3, 1));

    return 0;
}

void printVector(vector<int> v) {
    for (auto x : v) {
        cout << x << " ";
    }
    cout << endl;
}