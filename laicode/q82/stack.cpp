#include <iostream>

using namespace std;

class Solution {

public:
    void removeAdjacentIV(char* s) {
        int top = -1;
        for (int i = 0; s[i]; i++) {
            if (top == -1 || s[i] != s[top]) {
                s[++top] = s[i];
            } else {
                while (top != -1 && s[top] == s[i]) {
                    i++;
                }
                i--;
                top--;
            }
        }
        s[top + 1] = '\0';
    }
};

int main() {
    Solution sol;
    char s[] = "abbbbaaccz";
    sol.removeAdjacentIV(s);
    cout << s;
    return 0;
}