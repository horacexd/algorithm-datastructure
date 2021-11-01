package leetcode.q687;

public class Recursion1 {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = {1};
        longestUnivaluePath(root, max);
        return max[0] - 1;
    }
    
    private int longestUnivaluePath(TreeNode root, int[] max) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = longestUnivaluePath(root.left, max);
            left = root.val == root.left.val ? left : 0;
        }
        if (root.right != null) {
            right = longestUnivaluePath(root.right, max);
            right = root.val == root.right.val ? right : 0;
        }
        max[0] = Math.max(max[0], left + right + 1);
        return Math.max(left, right) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
