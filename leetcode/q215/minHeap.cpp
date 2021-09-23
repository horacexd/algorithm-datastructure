#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> minHeap;
        for (int i = 0; i < nums.size(); i++) {
            if (i < k) {
                minHeap.push(nums[i]);
            } else {
                if (minHeap.top() < nums[i]) {
                    minHeap.pop();
                    minHeap.push(nums[i]);
                }
            }
        }
        return minHeap.top();
    }
};

int main() {
    Solution s;
    vector<int> nums = {3, 2, 1, 5, 6, 4};
    cout << s.findKthLargest(nums, 2) << endl;
    return 0;
}