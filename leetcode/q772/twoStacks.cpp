#include <iostream>
#include <stack>
#include <vector>

using namespace std;

class Solution {
public:
    int calculate(string s) {
        stack<int> numStack;
        stack<char> optStack;
        int num;
        char c;
        for (int i = 0; i < s.size(); i++) {
            c = s[i];
            if (c >= '0' && c <= '9') {
                num = 0;
                while (i < s.size() && s[i] >= '0' && s[i] <= '9') {
                    num = 10 * num + s[i] - '0';
                    i++;
                }
                i--;
                numStack.push(num);
            } else if (c == '(') {
                optStack.push(s[i]);
            } else if (c == ')') {
                while (optStack.top() != '(') {
                    doCalculate(numStack, optStack);
                }
                optStack.pop(); // pop (
            } else {
                while (!optStack.empty() && getOrder(optStack.top()) >= getOrder(c)) {
                    doCalculate(numStack, optStack);
                }
                optStack.push(c);
            }
        }

        while (!optStack.empty()) {
            doCalculate(numStack, optStack);
        }
        return numStack.top();
    }

private:
    void doCalculate(stack<int>& numStack, stack<char>& optStack) {
        int num2 = numStack.top();
        numStack.pop();
        int num1 = numStack.top();
        numStack.pop();
        char opt = optStack.top();
        optStack.pop();
        int ans;
        switch (opt) {
            case '+':
                ans = num1 + num2;
                break;
            case '-':
                ans = num1 - num2;
                break;
            case '*':
                ans = num1 * num2;
                break;
            case '/':
                ans = num1 / num2;
                break;
            default:
                return;
        }
        numStack.push(ans);
    }

    int getOrder(char c) {
        switch (c) {
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
};

int main() {
    Solution s = Solution();
    cout << s.calculate("1*2-3/4+5*6-7*8+9/10");

    return 0;
}