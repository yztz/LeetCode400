/* https://leetcode.cn/problems/design-circular-queue/ */
public class s67 {
    static class MyCircularQueue {
        int[] buf;
        int head;
        int rear;
        int rlen;

        public MyCircularQueue(int k) {
            this.buf = new int[k + 1];
            this.head = 0;
            this.rear = 0;
            this.rlen = k + 1;
        }

        public boolean enQueue(int value) {
            if(isFull()) return false;
            buf[rear] = value;
            rear = (rear + 1) % rlen;
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()) return false;
            head = (head + 1) % rlen;
            return true;
        }

        public int Front() {
            if(isEmpty()) return -1;
            return buf[head];
        }

        public int Rear() {
            if(isEmpty()) return -1;
            return buf[(rear + rlen - 1) % rlen];
        }

        public boolean isEmpty() {
            return head == rear;
        }

        public boolean isFull() {
            return (rear + 1) % rlen == head;
        }
    }
}
