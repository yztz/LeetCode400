/* https://leetcode.cn/problems/longest-univalue-path/ */
public class s73 {
    int max;

    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        solve(root);
        return max;
    }

    public int solve(TreeNode root) {
        if(root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        int ans = 0;

        if(root.left != null) {
            if(root.val == root.left.val) {
                ans = left + 1;
            }
        }

        if(root.right != null) {
            if(root.val == root.right.val) {
                ans = Math.max(ans, right + 1);
            }
        }

        if(root.left != null && root.right != null) {
            if(root.left.val == root.val && root.right.val == root.val) {
                max = Math.max(max, left + right + 2);
            }
        }

        max = Math.max(max, ans);

        return ans;

    }


}
