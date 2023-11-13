package test;

public class Node {
    public Node left, right;
    char val;

    public Node() {

    }

    public Node(char val) {
        this.val = val;
    }

    public static Node build(char[] numbers) {
        return build(numbers, 0);
    }

     private static Node build(char[] numbers, int idx) {
        if (idx >= numbers.length || numbers[idx] == 0) return null;
        Node node = new Node(numbers[idx]);
        node.left = build(numbers, idx * 2 + 1);
        node.right = build(numbers, idx * 2 + 2);

        return node;
    }

}
