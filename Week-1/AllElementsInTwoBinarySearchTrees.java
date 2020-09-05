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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> sorted1 = new ArrayList<Integer>();
        List<Integer> sorted2 = new ArrayList<Integer>();
        inorder(root1, sorted1);
        inorder(root2, sorted2);
        
        List<Integer> result = new ArrayList<Integer>();
        int i = 0, j = 0;
        int m = sorted1.size(), n = sorted2.size();
        
        while(i < m && j < n) {
            if(sorted1.get(i) > sorted2.get(j)) {
                result.add(sorted2.get(j++));
            } else 
                result.add(sorted1.get(i++));
        }
        while(i < m)
            result.add(sorted1.get(i++));
        while(j < n)
            result.add(sorted2.get(j++));
        
        return result;
    }
    
    public static void inorder(TreeNode root, List<Integer> sortedResult) {
        if(root == null)
            return;
        inorder(root.left, sortedResult);
        sortedResult.add(root.val);
        inorder(root.right, sortedResult);
    }
}