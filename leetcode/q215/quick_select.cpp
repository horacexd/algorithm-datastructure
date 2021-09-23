#include <vector>
#include <iostream>
#include <ctime>
#include <cstdlib>

using namespace std;
class Solution
{
public:
    int findKthLargest(vector<int> &nums, int k)
    {
        if (nums.empty() || k <= 0 || k > nums.size())
        {
            return -1;
        }

        int l = 0, r = nums.size() - 1, p;
        while (l <= r)
        {
            p = getPartition(nums, l, r);
            if (nums.size() - k == p)
            {
                return nums[p];
            }
            if (nums.size() - k > p)
            {
                l = p + 1;
            }
            else
            {
                r = p - 1;
            }
        }
        return -1;
    }

private:
    int getPartition(vector<int> &nums, int l, int r)
    {
        srand(time(0));
        int pIndex = l + rand() % (r - l + 1);
        int pValue = nums[pIndex];
        swap(nums, pIndex, nums.size() - 1);
        int leftBound = l;
        int rightBound = r - 1;
        while (leftBound <= rightBound)
        {
            if (nums[leftBound] <= pValue)
            {
                leftBound++;
            }
            else if (nums[rightBound] > pValue)
            {
                rightBound--;
            }
            else
            {
                swap(nums, leftBound++, rightBound--);
            }
        }
        swap(nums, leftBound, r);
        return leftBound;
    }

private:
    void swap(vector<int> &nums, int i, int j)
    {
        if (i == j)
            return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
};
