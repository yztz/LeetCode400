import java.util.ArrayDeque;
import java.util.Deque;
/* https://leetcode.cn/problems/successor-lcci/ */
public class s12 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode prev = null, curr = root;
        while (!deque.isEmpty() || curr != null) {
            while (curr != null) {
                deque.push(curr);
                curr = curr.left;
            }
            curr = deque.pop();
            if (prev == p) return curr;
            prev = curr;
            curr = curr.right;
        }

        return null;
    }
}
