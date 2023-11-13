/* https://leetcode.cn/problems/design-linked-list/ */
public class s89 {
    static class MyLinkedList {
        private Node head;
        private int len = 0;

        public MyLinkedList() {
            head = new Node();
        }

        private Node getNode(int index) {
            if (index < 0 || index >= len) return null;
            Node ans;
            if (index <= len / 2) {
                ans = head.next;
                for (int i = 0; i < index; i++) {
                    ans = ans.next;
                }
            } else {
                ans = head.pre;
                for (int i = 0; i < len - index - 1; i++) {
                    ans = ans.pre;
                }
            }

            return ans;

        }

        public int get(int index) {
            Node node = getNode(index);
            return node == null ? -1 : node.val;
        }

        private void insertNode(Node pre, Node next, Node node) {
            node.next = next;
            node.pre = pre;
            next.pre = node;
            pre.next = node;
            len++;
        }

        private void removeNode(Node node) {
            Node next = node.next;
            Node pre = node.pre;
            next.pre = pre;
            pre.next = next;
            len--;
        }



        public void addAtHead(int val) {
            Node node = new Node(val);
            insertNode(head, head.next, node);
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            insertNode(head.pre, head, node);
        }

        public void addAtIndex(int index, int val) {
            if (index > len || index < 0) return;
            if (index == len) {
                addAtTail(val);
            } else {
                Node node = getNode(index);
                assert node != null;
                insertNode(node.pre, node, new Node(val));
            }
        }

        public void deleteAtIndex(int index) {
            Node node = getNode(index);
            if (node != null) {
                removeNode(node);
            }
        }


        static class Node {
            Node pre;
            Node next;
            int val = -1;

            Node() {
                pre = this;
                next = this;
            }

            Node(int val) {
                pre = this;
                next = this;
                this.val = val;
            }
        }
    }
}
