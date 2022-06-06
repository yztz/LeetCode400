import java.util.Map;
import java.util.TreeMap;
/* https://leetcode.cn/problems/my-calendar-iii/ */
public class s33 {
    static class MyCalendarThree {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        public MyCalendarThree() {

        }

        public int book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int tmp = 0;
            int ans = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                tmp += entry.getValue();
                ans = Math.max(tmp, ans);
            }
            return ans;
        }
    }
}
