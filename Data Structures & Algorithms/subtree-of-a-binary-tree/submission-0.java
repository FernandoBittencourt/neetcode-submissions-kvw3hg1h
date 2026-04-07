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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        if(compareSubTree(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) ||
        isSubtree(root.right, subRoot);
    }

    private boolean compareSubTree(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null){
            return true;
        } else if(root==null || subRoot==null){
            return false;
        } 
        if(subRoot.val!=root.val){
            return false;
        }
        return compareSubTree(root.left, subRoot.left) 
        && compareSubTree(root.right, subRoot.right);
    }

}
