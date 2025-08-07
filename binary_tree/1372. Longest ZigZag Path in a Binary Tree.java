1372. Longest ZigZag Path in a Binary Tree

You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
Change the direction from right to left or from left to right.
Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.

Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).

Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxZigZag = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null) return 9;
        dfs(root.left,1,true);
        dfs(root.right,1,false);
        return maxZigZag;
    }
    public void dfs(TreeNode root, int length, boolean isLeft){
        if(root == null) return ;

        maxZigZag = Math.max(length,maxZigZag);
        if(isLeft){
            dfs(root.right,length +1, false);
            dfs(root.left,1,true);
        }else{
            dfs(root.left,length + 1,true);
            dfs(root.right,1, false);
        }

    }

}
