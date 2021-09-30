#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    bool isValidSerialization(string preorder) {
        vector<string> array;
        size_t pos;
        while ((pos = preorder.find(",")) != string::npos) {
            array.push_back(preorder.substr(0, pos));
            preorder = preorder.substr(pos + 1);
        }
        array.push_back(preorder);
        int preIndex = 0;
        isValidSerialization(array, preIndex);
        return preIndex == array.size();
    }

private:
    void isValidSerialization(const vector<string>& array, int& preIndex) {
        if (preIndex >= array.size() || array[preIndex] == "#") {
            preIndex++;
            return;
        }
        preIndex++;
        isValidSerialization(array, preIndex);
        isValidSerialization(array, preIndex);
    }
};

int main() {
    Solution s;
    s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    return 0;
}