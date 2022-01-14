class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        indexMap = {0: -1}
        globalMax = 0
        preSum = 0
        for i in range(len(nums)): # you can omit 0 if you start from 0
            if nums[i] == 0:
                preSum -= 1
            else:
                preSum += 1
            if preSum in indexMap:
                globalMax = max(globalMax, i - indexMap[preSum])
            else:
                indexMap[preSum] = i
        return globalMax