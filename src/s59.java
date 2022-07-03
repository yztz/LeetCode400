import java.util.PriorityQueue;

public class s59 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->b - a);

        int remain = startFuel;
        int loc = 0;
        int ans = 0;
        int i = 0;

        while (loc < target) {
            loc += remain;
            while(i < n && stations[i][0] <= loc) {
                queue.offer(stations[i][1]);
                i++;
            }
            if (loc < target) {
                if (queue.isEmpty()) return -1;
                ans++;
                remain = queue.poll();
            }
        }

        return ans;

    }

    void backtrace(int[][] stations, int[] dp, int next) {

    }
}
