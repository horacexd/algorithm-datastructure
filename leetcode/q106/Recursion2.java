package leetcode.q106;

public class Recursion2 {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] inIndex = {inorder.length - 1};
        int[] postIndex = {postorder.length - 1};
        return buildTree(inorder, inIndex, postorder, postIndex, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[] inorder, int[] inIndex, int[] postorder, int[] postIndex, int rootValue) {
        if (postIndex[0] < 0 || inorder[inIndex[0]] == rootValue) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex[0]]);
        postIndex[0]--;
        root.right = buildTree(inorder, inIndex, postorder, postIndex, root.val); // root.right 当前root的subtree开始构建
        inIndex[0]--;
        root.left = buildTree(inorder, inIndex, postorder, postIndex, rootValue); // root.right 的所有subtree全部构建完毕
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
