var findMaxLength = function(nums) {
    const indexMap = new Map();
    indexMap.set(0, -1);
    let globalMax = 0;
    let preSum = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
            preSum -= 1;
        } else {
            preSum += 1;
        }
        if (indexMap.has(preSum)) {
            globalMax = Math.max(globalMax, i - indexMap.get(preSum));
        } else {
            indexMap.set(preSum, i);
        }
    }
    return globalMax;
};

console.log(findMaxLength([0, 1]));