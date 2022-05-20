import java.util.Arrays;
import java.util.Comparator;
/* https://leetcode.cn/problems/find-right-interval/ */

public class s16 {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        int[][] startIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }

        Arrays.sort(startIntervals, Comparator.comparingInt(a -> a[0]));

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = bs(startIntervals, intervals[i][1]);
        }

        return ans;
    }

    int bs(int[][] intervals, int target) {
        int left = 0, right = intervals.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            int[] interval = intervals[mid];
            if (interval[0] < target) {
                left = mid + 1;
            } else {
                ans = intervals[mid][1];
                right = mid - 1;
            }
        }

        return  ans;
    }
}
