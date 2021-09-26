#include <iostream>
#include <string>
#include <unordered_set>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> sset;
        int i = 0;
        int globalMax = 0;
        for (int j = 0; j < s.size(); j++) {
            while (sset.count(s[j]) > 0) {
                sset.erase(s[i]);
                i++;
            }
            sset.insert(s[j]);
            globalMax = max(globalMax, j - i + 1);
        }
        return globalMax;
    }
};