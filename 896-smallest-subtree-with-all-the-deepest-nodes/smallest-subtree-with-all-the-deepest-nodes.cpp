/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:

    void findLevel(TreeNode* root, int&level, int temp)
    {
        if(root==NULL)
        {
            level = max(level,temp);
            return;
        }
        findLevel(root->left,level,temp+1);
        findLevel(root->right,level,temp+1);
    }

    bool helper(TreeNode* root, int &level, int temp, TreeNode*& ans)
    {
        if(root==NULL)
        {
            return temp==level;
        }
        bool left = helper(root->left,level,temp+1,ans);
        bool right = helper(root->right,level,temp+1,ans);
        if(left && right)
        {
            ans = root;
        }
        return left||right;
    }


    TreeNode* subtreeWithAllDeepest(TreeNode* root) {
        int level = 0;
        findLevel(root,level,0);
        TreeNode* ans;
        helper(root,level,0,ans);
        return ans;
    }
};