import java.util.*;
/* https://leetcode-cn.com/problems/minimum-genetic-mutation/ */
public class s3 {
    static final char[] GENES = new char[]{'A', 'C', 'G', 'T'};
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        Map<String, Integer> map = new HashMap<>();
        for (String t : bank) map.put(t, 0);
        if (!map.containsKey(end)) return -1;

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String seq = queue.poll();
                StringBuilder sb = new StringBuilder(seq);
                if (seq.equals(end)) return ans;
                for (int i = 0; i < 8; i++) {
                    char c = sb.charAt(i);
                    for (char re : GENES) {
                        if (re == c) continue;
                        sb.setCharAt(i, re);
                        String news = sb.toString();
                        if (map.getOrDefault(news, -1) == 0) {
                            queue.add(news);
                            map.put(news, 1);
                        }
                        sb.setCharAt(i, c);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
