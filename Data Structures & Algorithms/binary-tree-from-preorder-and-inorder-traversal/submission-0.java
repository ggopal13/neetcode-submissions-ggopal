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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 && inorder.length == 0)
            return null;
        
        TreeNode root = new TreeNode(preorder[0]);

        int index = -1;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == preorder[0]){
                index = i;
                break;
            }
        }

        int[] leftPreOrder = Arrays.copyOfRange(preorder,1,index+1);
        int[] leftInorder = Arrays.copyOfRange(inorder,0,index);

        int[] rightPreOrder = Arrays.copyOfRange(preorder,index+1,preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder,index+1,inorder.length);

        root.left = buildTree(leftPreOrder,leftInorder);
        root.right = buildTree(rightPreOrder,rightInorder);

        return root;


    }
}
