import java.util.Arrays;
/* https://leetcode.cn/problems/orderly-queue/ */
public class s69 {
    public String orderlyQueue(String s, int k) {
        int n = s.length();
        String min;
        if(k == 1) {
            min = s;
            for(int i = 1; i < n; i++) {
                String t = s.substring(i) + s.substring(0, i);
                if(min.compareTo(t) > 0) {
                    min = t;
                }
            }
        } else {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            min = new String(chs);
        }
        return min;
    }
}
