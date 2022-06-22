/* https://leetcode.cn/problems/find-bottom-left-tree-value/ */
public class s49 {
    int maxDepth;
    TreeNode ans;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return ans.val;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;

        if (node.right != null || node.left != null) {
            dfs(node.right, level + 1);
            dfs(node.left, level + 1);
        } else if (level >= maxDepth) {
            maxDepth = level;
            ans = node;
        }

    }
}
