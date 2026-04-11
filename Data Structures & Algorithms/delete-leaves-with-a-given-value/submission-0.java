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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        boolean res = deleteLeaf(root,target);
        if(res) return null;
        return root;
    }

    private boolean deleteLeaf(TreeNode root, int target){
        if(root == null)
            return true;
        
        if(root.left == null && root.right == null && root.val == target){
            return true;
        }

        boolean left = deleteLeaf(root.left,target);
        boolean right = deleteLeaf(root.right,target);

        if(left)
            root.left = null;
        
        if(right)
            root.right = null;

        return (left && right && root.val == target);
    }
}