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

    int diameter = 0;
    Map<TreeNode, Integer> mp = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null)
            return 0;

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return diameter = Math.max(diameter, height(root.left) + height(root.right));

    }

    public int height(TreeNode root) {
        
        if(root == null)
            return 0;

        if(mp.containsKey(root) == true)
            mp.get(root);

        int lh = height(root.left);
        mp.put(root.left, lh);
        int rh = height(root.right);
        mp.put(root.right, rh);
        
        return (1 + Math.max(lh, rh));

    }
}
