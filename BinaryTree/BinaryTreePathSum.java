//Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.

//A valid path is from root node to any of the leaf nodes.

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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Algorithm: Traverse
        // Use recursion to traverse the tree in preorder, pass with a parameter
        // `sum` as the sum of each node from root to current node.
        // Put the whole path into result if the leaf has a sum equal to target.        
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<>();
        path.add(root.val);
        helper(root, path, target, root.val, result);
        return result;
    }
    
    public void helper(TreeNode root, ArrayList<Integer> path, int target, int sum, ArrayList<List<Integer>> result) {
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
        
        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, path, target, sum + root.left.val, result);
            path.remove(path.size() - 1);
            //把这次加的root给删了 因为onePath这个arrayList是唯一的
            //比方说随着dfs的越来越深入
            //Path里面的int也越来越多。直到到叶子节点 如果是对的值放result
            //但是随着递归方法结束的返回
            //每一层都把自己加的那个值删掉，最后返回调用层的时候 那些由递归层
            //加的数字又删掉了。 比方说find_sum(result, onePath, root.left, sum); 然后 Path里int越来越多
            //但是递归都返回的时候 又都删掉了
            //所以 find_sum(result, onePath, root.right, sum); 也从正常的位置开始加
        }
        
        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, path, target, sum + root.right.val, result);
            path.remove(path.size() - 1);
        }
    }
}