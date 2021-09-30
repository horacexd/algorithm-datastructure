#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;


class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        unordered_map<int, int> inmap;
        for (int i = 0; i < inorder.size(); i++) {
            inmap[inorder[i]] = i;
        }
        return buildTree(postorder, 0, postorder.size() - 1, inmap, 0, inorder.size() - 1);
    }
private:
    TreeNode* buildTree(const vector<int>& postorder, int pLeft, int pRight, const unordered_map<int, int>& inmap, int inLeft, int inRight) {
        if (pLeft > pRight) {
            return NULL;
        }
        int val = postorder[pRight];
        TreeNode* root = new TreeNode(val);
        int inIndex = inmap.at(val);
        int rightSize = inRight - inIndex;
        root->left = buildTree(postorder, pLeft, pRight - rightSize - 1, inmap, inLeft, inIndex - 1);
        root->right = buildTree(postorder, pRight - rightSize, pRight - 1, inmap, inIndex + 1, inRight);
        return root;
    }
};

class TreeNode {
public:
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode() : val(val), left(NULL), right(NULL) {}
    TreeNode(int val) : left(NULL), right(NULL) {
        this->val = val;
    }
};
