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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();

        pStack.push(p);
        qStack.push(q);

        while(!pStack.empty() && !qStack.empty()){
            TreeNode pNode = pStack.pop();
            TreeNode qNode = qStack.pop();

            if(pNode == qNode) continue;

            if(pNode == null || qNode == null)  return false;

            if(pNode.val!=qNode.val) return false;

        //     if(pNode.left != null && qNode.left == null) return false; 
        //     if(pNode.left == null && qNode.left != null) return false; 
        //    if(pNode.right != null && qNode.right == null) return false; 
        //     if(pNode.right == null && qNode.right != null) return false; 

           
                pStack.push(pNode.left);
                qStack.push(qNode.left);
            


                pStack.push(pNode.right);
                qStack.push(qNode.right);
            
        }

        if(!pStack.empty() || !qStack.empty())
            return false;

        return true;
    }
}
