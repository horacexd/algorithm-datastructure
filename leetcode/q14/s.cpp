#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        // assume strs is not empty
        // assume strs size > 1

        if (strs.size() <= 1) {
            return "";
        }

        string ret;
        for (int i = 0; i < strs[0].size(); i++) {
            char c = strs[0][i];
            for (int j = 1; j < strs.size(); j++) {
                if (i >= strs[j].size()) {
                    return ret;
                }
                if (strs[j][i] != c) {
                    return ret;
                }
            }
            ret += c;
        }
        return ret;
    }
};

int main(int argc, char** argv) {
    Solution s;
    vector<vector<string>> vs = { 
        {"flabc", "flggd", "fl"},
        {"abc", "gg", "sd"},
        {"dog","racecar","car"}
    };

    for (auto v : vs) {
        cout << s.longestCommonPrefix(v) << endl;
    }
    return 0;
}