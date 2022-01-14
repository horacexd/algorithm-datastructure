import scala.collection.mutable

object Solution {
    def findMaxLength(nums: Array[Int]): Int = {
        val map = mutable.Map[Int, Int]()
        map.put(0, -1)
        
        var globalMax = 0
        var preSum = 0

        for (i <- (0 until nums.size)) {
            preSum += (if (nums(i) == 1) 1 else -1)
            if (map.contains(preSum)) {
                globalMax = math.max(globalMax, i - map.get(preSum).get)
            } else {
                map.put(preSum, i)
            }
        }
        globalMax
    }
}