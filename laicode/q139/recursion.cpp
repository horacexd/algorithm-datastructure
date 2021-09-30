#include <iostream>

using namespace std;

class Solution {
public:
    int maxPathSum(TreeNode* root) {
        // assume root is not NULL
        int res = INT_MIN;
        maxPathSum(root, res);
        return res;
    }
private:
    int maxPathSum(TreeNode* root, int& res) {
        if (root == NULL) {
            return 0;
        }
        int l = maxPathSum(root->left, res);
        int r = maxPathSum(root->right, res);
        l = l > 0 ? l : 0;
        r = r > 0 ? r : 0;
        res = max(l + r + root->value, res);
        return max(l, r) + root->value;
    }
};

class TreeNode {
public:
    int value;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int v) : value(v), left(NULL), right(NULL) {} 
};

int main() {

}