/* https://leetcode.cn/problems/4ueAj6/ */
public class s45 {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }

        Node pre = head;
        while (true) {
            if (pre.val > pre.next.val) {
                if (insertVal <= pre.next.val || insertVal > pre.val) break;
            }
            if (pre.val <= insertVal && pre.next.val >= insertVal) {
                break;
            }
            pre = pre.next;
            if (pre == head) break;
        }
        node.next = pre.next;
        pre.next = node;

        return head;
    }
}

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
