import java.util.HashMap;
import java.util.Map;
/* https://leetcode.cn/problems/longest-uncommon-subsequence-ii/ */
public class s54 {
    public int findLUSlength(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            int n = str.length();
            for (int i = 1; i < (1 << n); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) > 0) {
                        sb.append(str.charAt(j));
                    }
                }
                String sub = sb.toString();
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }

        int max = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println("entry: " + entry.getKey() + " value: " + entry.getValue());
            if (entry.getValue() == 1) {
                max = Math.max(max, entry.getKey().length());
            }
        }
        return max;
    }
}
