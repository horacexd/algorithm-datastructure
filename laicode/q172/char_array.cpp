#include <string>
#include <iostream>

using namespace std;

class Solution {
public:
    string replace(string input, string source, string target) {
        if (input.size() < source.size()) {
            return input;
        }
        int index = input.find(source);
        string res;
        while (index != -1) {
            res += input.substr(0, index);
            res += target;
            input = input.substr(index + source.size());
            index = input.find(source);
        }
        res += input;
        return res;
    }
};

int main() {
    string input, s, t;
    cin >> input >> s >> t;
    Solution sol;
    cout << sol.replace(input, s, t);
    return 0;
}