#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int findContentChildren(vector<int>& s, vector<int>& g) {
        sort(s.begin(), s.end());
        sort(g.begin(), g.end());

        int i = 0;
        int j = 0;
        int count = 0;
        while (i < s.size() && j < g.size()) {
            if (s[i] >= g[j]) {
                i++;
                j++;
                count++;
            } else {
                i++;
            }
        }
        return count;
    }
};

int main(int argc, char** argv) {
    Solution s;
    vector<vector<int>> ss = {
        {1, 1},
        {7, 6, 5, 8},
        {7, 4, 9, 4}
    };
    vector<vector<int>> gs = {
        {1, 2, 3},
        {9, 8, 10, 7},
        {5, 8, 3, 4}
    };

    for (int i = 0; i < ss.size(); i++) {
        cout << s.findContentChildren(ss[i], gs[i]) << endl;
    }

    return 0;
}