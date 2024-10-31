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
// binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // 둘 다 null인 경우 true
        if (root1 == null && root2 == null) {
            return true;
        }
        
        // 하나만 null이거나 값이 다른 경우 false
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        
        // 재귀로 flip 없이 동일한 경우 랑 flip 한 경우
        
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
               (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}