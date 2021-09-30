package laicode.q139;

public class Recursion {

    public int maxPathSum(TreeNode root) {
        // assume root is not null
        int[] max = {Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }

    private int maxPathSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSum(root.left, max);
        int right = maxPathSum(root.right, max);
        left = left > 0 ? left : 0;
        right = right > 0 ? right : 0;
        max[0] = Math.max(max[0], left + right + root.key);
        return Math.max(left, right) + root.key;
    }
}

class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    TreeNode(int key) {
        this.key = key;
        left = right = null;
    }
}