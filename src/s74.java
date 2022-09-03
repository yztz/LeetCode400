/* https://leetcode.cn/problems/maximum-length-of-pair-chain/ */
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class s74 {
    Map<Integer, Integer> map = new HashMap<>();

    int max = 0;

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
//        for(int[] pair : pairs) {
//            System.out.println(Arrays.toString(pair));
//        }
        backtrace(pairs, 0);

        return max;
    }

    int backtrace(int[][] pairs, int pre) {
        if (map.containsKey(pre)) return map.get(pre);
        int n = pairs.length;
        int ans = 0;
        int[] pair = pairs[pre];
        for (int i = pre + 1; i < n; i++) {
            if (pairs[i][0] > pair[1]) {
                ans = Math.max(ans, backtrace(pairs, i));
            } else {
                int backtrace = backtrace(pairs, i);
//                System.out.println("backtrace " + backtrace);
                max = Math.max(max, 1 + backtrace);
            }
        }
        ans += 1;

        max = Math.max(max, ans);
        map.put(pre, ans);
        return ans;
    }


}
