import java.util.HashMap;
import java.util.Map;
/* https://leetcode.cn/problems/next-greater-element-iii/ */
public class s60 {
    public int nextGreaterElement(int n) {
        String num = String.valueOf(n);
        Map<Integer, Integer> map = new HashMap<>();
        for (char c : num.toCharArray()) {
            map.put(c - '0', map.getOrDefault(c - '0', 0) + 1);
        }
        return backtrace(map, num, 0, 0, n, true);
    }


    int backtrace(Map<Integer, Integer> map, String n, int th, long ans, int num, boolean compare) {
        if (th == n.length()) {
            if (ans > num && ans <= Integer.MAX_VALUE) return (int)ans;
            return -1;
        }
        int c = n.charAt(th) - '0';
        for (int i = compare ? c : 0; i < 10; i++) {
            int cnt = map.getOrDefault(i, 0);
            if (cnt == 0) continue;
            map.put(i, cnt - 1);
            ans = ans * 10 + i;
            int ret = backtrace(map, n, th + 1, ans, num, i == c && compare);
            if (ret != -1) return ret;
            ans /= 10;
            map.put(i, cnt);
        }

        return -1;
    }
}
