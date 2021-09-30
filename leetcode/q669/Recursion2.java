package leetcode.q669;

public class Recursion2 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return trimBST(root, low, high, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode trimBST(TreeNode root, int low, int high, int min, int max) {
        if (root == null) {
            return null;
        }
        if (min >= low && max <= high) { // if value range inside the [low, high], we don't need to do anything
            return root;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high, root.val, max); // only need to check right side, return updated root to connect
        }
        if (root.val > high) {
            return trimBST(root.left, low, high, min, root.val); // only need to check left side, return updated root to connect
        }
        // current root will be kept
        root.left = trimBST(root.left, low, high, min, root.val); // make connection on its left child
        root.right = trimBST(root.right, low, high, root.val, max); // make connection on its right child
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
    }
}
