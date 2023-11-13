import utils.TreeNode;

/* https://leetcode.cn/problems/maximum-binary-tree-ii/ */
public class s70 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val <= val) {
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        } else {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
