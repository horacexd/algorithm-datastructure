#include <iostream>
#include <stack>

using namespace std;

class Solution {
public:
    int largestRectangle(int* arr, int size) {
        stack<int> s;
        int globalMax = 0;
        for (int i = 0; i <= size; i++) {
            int cur = i == size ? 0 : arr[i];
            while (!s.empty() && arr[s.top()] >= cur) {
                int height = arr[s.top()];
                s.pop();
                int left = s.empty() ? 0 : arr[s.top()] + 1;
                globalMax = max(globalMax, height * (i - left));
            }
            s.push(i);
        }
        return globalMax;
    }
};

int main() {
    Solution sol;
    int arr[] = {2, 1, 5, 6, 2, 3};
    cout << sol.largestRectangle(arr, 6);
    return 0;
}