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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stkP = new Stack<>();
        Stack<TreeNode> stkQ = new Stack<>();

        preOrderTraversal(root, p, new Stack<TreeNode>(), stkP);
        preOrderTraversal(root, q, new Stack<TreeNode>(), stkQ);

        while(true) {
            while(stkP.size() > stkQ.size())
                stkP.pop();

            while(stkQ.size() > stkP.size())
                stkQ.pop();
            
            if(stkP.peek().val == stkQ.peek().val)
                return stkP.peek();
            
            stkP.pop();
            stkQ.pop();
        }
    }

    public void preOrderTraversal(TreeNode root, TreeNode target, Stack<TreeNode> stk, Stack<TreeNode> newStk) {
        if(root == null)
            return;
        
        stk.push(root);

        if(root.val == target.val){
            newStk.addAll(stk);
            stk.pop();
            return;
        }

        preOrderTraversal(root.left, target, stk, newStk);
        preOrderTraversal(root.right, target, stk, newStk);
        stk.pop();
    }
}
