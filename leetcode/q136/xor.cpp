#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        // assume nums have one and only one single number
        // assume nums is not empty
        int ret = 0;
        for (auto x : nums) {
            ret ^= x;
        }

        return ret;
    }
};

int main(int argc, char** argv) {
    Solution s;
    vector<vector<int>> vs = {
        {1, 2, 1},
        {2, 2, 3},
        {4, 5, 4, 3, 3, 5, 7},
    };

    for (auto v : vs) {
        cout << s.singleNumber(v) << endl;
    }

    return 0;
}