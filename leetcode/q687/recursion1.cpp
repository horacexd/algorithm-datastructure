#include <iostream>

using namespace std;

class Solution {
public:
    int longestUnivaluePath(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int mmax = 1;
        longestUnivaluePath(root, mmax);
        return mmax - 1;
    }

private:
    int longestUnivaluePath(TreeNode* root, int& mmax) {
        if (root->left == nullptr && root->right == nullptr) {
            return 1;
        }
        int left = 0, right = 0;
        if (root->left != nullptr) {
            left = longestUnivaluePath(root->left, mmax);
            left = root->left->val == root->val ? left : 0;
        }
        if (root->right != nullptr) {
            right = longestUnivaluePath(root->right, mmax);
            right = root->right->val == root->val ? right : 0;
        }

        mmax = max(mmax, left + right + 1);
        return max(left, right) + 1;
    }
};