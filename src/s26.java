import java.util.ArrayDeque;
import java.util.Deque;
/* https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/ */
public class s26 {
    int ans = 0;

    //    public int sumRootToLeaf(TreeNode root) {
//        preorder(root, 0);
//        return ans;
//    }
    public int sumRootToLeaf(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        int ans = 0;
        int tmp = 0;
        TreeNode pre = null;
        TreeNode node = root;
        while (node != null || !deque.isEmpty()) {
            while (node != null) {
                deque.push(node);
                tmp = tmp << 1 | node.val;
                node = node.left;
            }
            node = deque.peek();
            if (node.right == null && node.left == null)
                ans += tmp;
            if (node.right == null || node.right == pre) {
                deque.pop();
                tmp >>= 1;
                pre = node;
                node = null;
            } else {
                node = node.right;
            }
        }

        return ans;
    }

    private void preorder(TreeNode root, int val) {
        if (root == null) return;
        val = val * 2 + root.val;

        if (root.left == null && root.right == null) {
            ans += val;
            return;
        }

        preorder(root.left, val);
        preorder(root.right, val);
    }

}
