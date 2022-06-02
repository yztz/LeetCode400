import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class s28 {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        if(n < 4) return false;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int matchstick : matchsticks) {
            queue.add(matchstick);
        }
        while (queue.size() > 4) {
            int a = queue.poll();
            int b = queue.poll();
            queue.offer(a + b);
        }
        Integer[] array = new Integer[4];
        queue.toArray(array);
        for (int i = 1; i < 4; i++) {
            if (!Objects.equals(array[i], array[i - 1]))
                return false;
        }
        return true;
    }
}
