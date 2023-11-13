import utils.TreeNode;

/* https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/description/ */
public class s70 {
    TreeNode ans;
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean c = root.val == p.val || root.val == q.val;
        boolean l = dfs(root.left, p, q);
        boolean r = dfs(root.right, p, q);

        if ((l && r || l && c || r && c) && ans == null) ans = root;

        return l || r || c;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
}
