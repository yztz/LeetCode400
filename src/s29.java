public class s29 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode fake = new TreeNode(Integer.MAX_VALUE);
        fake.left = root;
        boolean lf = true;
        TreeNode pre = fake;
        TreeNode node = root;
        while (node != null && node.val != key) {
            pre = node;
            lf = node.val > key;
            node = node.val > key ? node.left : node.right;
        }
        if (node == null) return root;
        if (node.right == null) {
            setChild(pre, node.left, lf);
            return fake.left;
        }
        if (node.left == null) {
            setChild(pre, node.right, lf);
            return fake.left;
        }

        setChild(pre, node.right, lf);
        pre = node.right;
        while (pre.left != null) pre = pre.left;
        pre.left = node.left;

        return fake.left;
    }

    private void setChild(TreeNode root, TreeNode child, boolean left) {
        if (left) {
            root.left = child;
        } else {
            root.right = child;
        }
    }
}
