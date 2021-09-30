#include <iostream>

using namespace std;

class Solution {
public:
    TreeNode* trimBST(TreeNode* root, int low, int high) {
        return trimBST(root, low, high, INT_MIN, INT_MAX);
    }

private:
    TreeNode* trimBST(TreeNode* root, const int& low, const int& high, int min, int max) {
        if (root == nullptr) {
            return nullptr;
        }
        if (min >= low && max <= high) {
            return root;
        }
        if (root->val < low) {
            return trimBST(root->right, low, high, root->val, max);
        }
        if (root->val > high) {
            return trimBST(root->left, low, high, min, root->val);
        }
        root->left = trimBST(root->left, low, high, min, root->val);
        root->right = trimBST(root->right, low, high, root->val, max);
        return root;
    }
};

class TreeNode {
public:
    int val;
    TreeNode* left;
    TreeNode* right;
};