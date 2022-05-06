import java.util.ArrayDeque;
import java.util.Queue;

/* https://leetcode-cn.com/problems/number-of-recent-calls/ */
public class s2 {
    static class RecentCounter {
        Queue<Integer> queue = new ArrayDeque<>();
        public RecentCounter() {

        }

        public int ping(int t) {
            int before = t - 3000;
            queue.offer(t);
            while (queue.peek() < before) queue.poll();

            return queue.size();
        }


    }

}


