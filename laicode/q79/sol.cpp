#include <iostream>

using namespace std;

class Solution {

public:
    int removeAdjacentI(char* s) {
        int slow = 0;
        for (int i = 1; s[i]; i++) {
            if (s[slow] != s[i]) {
                s[++slow] = s[i];
            }
        }
        return slow + 1;
    }
};

int main() {
    Solution sol;
    char s[] = "aaaabbbc";
    cout << sol.removeAdjacentI(s);
    return 0;
}