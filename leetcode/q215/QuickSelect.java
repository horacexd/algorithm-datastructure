package leetcode.q215;

public class QuickSelect {

    public int kthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || nums.length < k) {
            return Integer.MAX_VALUE;
        }

        int left = 0;
        int right = nums.length - 1;
        int pIndex;
        while (left <= right) {
            pIndex = getPartition(nums, left, right);
            if (nums.length - k == pIndex) {
                return nums[pIndex];
            }
            if (nums.length - k > pIndex) {
                left = pIndex + 1;
            } else {
                right = pIndex - 1;
            }
        }
        return Integer.MAX_VALUE;
    }

    private int getPartition(int[] nums, int left, int right) {
        int pIndex = left + (int) (Math.random() * (right - left + 1));
        int pValue = nums[pIndex];
        swap(nums, pIndex, right);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (nums[leftBound] <= pValue) {
                leftBound++;
            } else if (nums[rightBound] > pValue) {
                rightBound--;
            } else {
                swap(nums, leftBound++, rightBound--);
            }
        }
        swap(nums, leftBound, right);
        return leftBound;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSelect s = new QuickSelect();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(s.kthLargest(nums, 2));
    }
}