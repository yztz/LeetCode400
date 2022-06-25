import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
/* https://leetcode.cn/problems/find-largest-value-in-each-tree-row/ */
public class s51 {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>(0);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            int max = Integer.MIN_VALUE;
            while (n-- > 0) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(max);
        }

        return ans;
    }
}
