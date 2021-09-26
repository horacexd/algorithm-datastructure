package laicode.q79;

class Solution {

    public int removeAdjacent(char[] array) {
        int slow = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[slow] != array[i]) {
                array[++slow] = array[i];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] array = "aaaabbbc".toCharArray();
        System.out.println(sol.removeAdjacent(array));
    }
}