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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root==null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> nodeLvl = new LinkedList<Integer>();
        queue.add(root);
        nodeLvl.add(0);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int lvl=nodeLvl.poll();
            if(result.size()==lvl){
                result.add(new ArrayList<Integer>());
            }
            result.get(lvl).add(node.val);
            lvl++;
            if(node.left!= null){
                queue.add(node.left);
                nodeLvl.add(lvl);
            }
            if(node.right!= null){
                queue.add(node.right); 
                nodeLvl.add(lvl);               
            }
        }
        return result;
    }
    
}
