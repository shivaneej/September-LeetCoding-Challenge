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
    public int sumRootToLeaf(TreeNode root) {
        int sum = 0;
        sum = dfs(root, "", sum);
        return sum;
    }
    public static int dfs(TreeNode root, String parent, int sum) {
        if (root == null) 
            return 0; 
        parent = parent + root.val;
        if(root.left == null && root.right == null) {
            sum += Integer.parseInt(parent, 2);
            return sum;
        }
        return dfs(root.left, parent, sum) + dfs(root.right, parent, sum); 
    }
}