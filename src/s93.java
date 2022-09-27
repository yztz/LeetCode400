/* https://leetcode.cn/problems/check-permutation-lcci/ */
import java.util.HashMap;
import java.util.Map;

public class s93 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            int cnt = map.getOrDefault(c, 0);
            if (cnt != 0) {
                map.put(c, cnt - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
