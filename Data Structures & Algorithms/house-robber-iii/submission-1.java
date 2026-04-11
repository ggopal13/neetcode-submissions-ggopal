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
    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        map.put(null,0);
        return dfs(root);
    }

    private int dfs(TreeNode root){
        if(map.containsKey(root)) return map.get(root);

        int res = root.val;

        if(root.left!=null){
            res+= (rob(root.left.left) + rob(root.left.right));
        }

        if(root.right!=null){
            res+= (rob(root.right.left) + rob(root.right.right));
        }

        int max = Math.max(res, rob(root.left) + rob(root.right));
        map.put(root,max);

        return max;
    }
}