package leetcode.q106;

import java.util.Map;
import java.util.HashMap;

public class Recursion1 {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        return buildTree(postorder, 0, postorder.length - 1, inMap, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] post, int pLeft, int pRight, Map<Integer, Integer> inMap, int iLeft, int iRight) {
        if (pLeft > pRight) {
            return null;
        }
        
        TreeNode root = new TreeNode(post[pRight]);
        int iIndex = inMap.get(post[pRight]);
        int rightSize = iRight - iIndex;
        root.left = buildTree(post, pLeft, pRight - rightSize - 1, inMap, iLeft, iIndex - 1);
        root.right = buildTree(post, pRight - rightSize, pRight - 1, inMap, iIndex + 1, iRight);
        return root;
    }
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
}
