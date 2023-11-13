package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Node tree = Node.build(new char[]{'A', 'B', 'C', 'D', 'E'});
        postOrder(tree);
    }


    private static void visitNode(Node node) {
        System.out.println(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;

        while (root != null || !stack.isEmpty()) {
            // 将当前节点的所有左节点推入栈中（包括节点本身）
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 查看栈头
            root = stack.peek();

            if (root.right == null || root.right == pre) { // 当前节点的右节点 为空 或者 已经被访问过
                // 访问当前节点
                stack.pop();
                res.add(root.val);
                pre = root;
                root = null;
            } else { // 否则 访问右节点
                root = root.right;
                // ...将右节点的所有左节点加入栈 （包括右节点本身）
            }
        }
        return res;
    }
    private static void postOrder(Node root) {
        if (root == null) return;

        Deque<Node> stack = new ArrayDeque<>();
        Node pre = null;

        while (root != null || !stack.isEmpty()) {
            // 将当前节点的所有左节点推入栈中（包括节点本身）
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 查看栈头
            root = stack.peek();

            if (root.right == null || root.right == pre) { // 当前节点的右节点 为空 或者 已经被访问过
                // 访问当前节点
                stack.pop();
                visitNode(root);
                pre = root;
                root = null;
            } else { // 否则 访问右节点
                root = root.right;
                // ...将右节点的所有左节点加入栈 （包括右节点本身）
            }

        }
    }
}







