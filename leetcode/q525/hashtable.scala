object Solution {
    def findMaxLength(nums: Array[Int]): Int = {
        var indexMap = Map(0 -> -1);
        var globalMax = 0;
        var preSum = 0;
        nums.zipWithIndex.foreach { case (item, index) => {
                if (item == 0) {
                    preSum -= 1;
                } else {
                    preSum += 1;
                }
                if (indexMap.contains(preSum)) {
                    globalMax = globalMax.max(index - indexMap(preSum));
                } else {
                    indexMap += (preSum -> index);
                }
            }
        }
        return globalMax;
    }
}