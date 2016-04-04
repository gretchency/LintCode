//Given a binary tree, return all root-to-leaf paths.

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<String>();
        if (root == null) {
            return list;
        }
        
        helper(root, list, String.valueOf(root.val));
        return list;
    }
    
    public void helper(TreeNode root, ArrayList<String> list, String path) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            list.add(path);
            return;
        }
        
        //一定要加判断,否则String.valueof(null)就gg了
        if (root.left != null) {
            helper(root.left, list, path + "->" + String.valueOf(root.left.val));
        }
        
        //同样加判断
        if (root.right != null) {
            helper(root.right, list, path + "->" + String.valueOf(root.right.val));
        }
    }
}