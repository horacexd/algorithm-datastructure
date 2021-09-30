#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int inIndex = inorder.size() - 1;
        int postIndex = postorder.size() - 1;
        return buildTree(inorder, inIndex, postorder, postIndex, INT_MAX);
    }

private:
    TreeNode* buildTree(const vector<int>& inorder, int& inIndex, const vector<int>& postorder, int& postIndex, int rootValue) {
        if (postIndex < 0 || rootValue == inorder[inIndex]) {
            return nullptr;
        }
        TreeNode* root = new TreeNode(postorder[postIndex]);
        postIndex--;
        root->right = buildTree(inorder, inIndex, postorder, postIndex, root->val);
        inIndex--;
        root->left = buildTree(inorder, inIndex, postorder, postIndex, rootValue);
        return root;
    }
};

class TreeNode {
public:
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};
