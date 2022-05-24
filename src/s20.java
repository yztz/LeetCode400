import java.util.ArrayDeque;
import java.util.Deque;
/* https://leetcode.cn/problems/univalued-binary-tree/ */
public class s20 {
    public boolean isUnivalTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        TreeNode node = root;
        int val = root.val;
        while (node != null || !deque.isEmpty()) {
            if (node == null) {
                node = deque.poll();
                if (val != node.val) return false;
                node = node.right;
            } else {
                deque.push(node);
                node = node.left;
            }
        }

        return true;
    }
}
