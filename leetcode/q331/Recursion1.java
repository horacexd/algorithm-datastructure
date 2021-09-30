package leetcode.q331;

public class Recursion1 {
    public boolean isValidSerialization(String preorder) {
        int[] preIndex = new int[1];
        String[] pre = preorder.split(",");
        isValidSerialization(pre, preIndex);
        return preIndex[0] == pre.length;
    }
    
    private void isValidSerialization(String[] pre, int[] preIndex) {
        if (preIndex[0] >= pre.length || pre[preIndex[0]].equals("#")) {
            preIndex[0]++;
            return;    
        }
        preIndex[0]++;
        isValidSerialization(pre, preIndex);
        isValidSerialization(pre, preIndex);
    }
}
