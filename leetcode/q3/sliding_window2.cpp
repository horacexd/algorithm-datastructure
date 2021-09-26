#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

class Solution {

public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> m;
        int i = 0;
        int globalMax = 0;
        for (int j = 0; j < s.size(); j++) {
            if (m.count(s[j]) > 0) {
                i = max(i, m[s[j]] + 1);
            }
            m[s[j]] = j;
            globalMax = max(globalMax, j - i + 1);
        }
        return globalMax;
    }
};