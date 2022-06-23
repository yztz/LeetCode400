import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* https://leetcode.cn/problems/substring-with-concatenation-of-all-words/ */
public class s50 {
    public List<Integer> findSubstring(String s, String[] words) {

        int wordLen = words[0].length();
        int total = words.length * wordLen;

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length() - total + 1; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            if (search(map, s, i, wordLen, words.length)) ans.add(i);
        }

        return ans;
    }

    boolean search(Map<String, Integer> map, String s, int begin, int wordlen, int n) {
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = s.substring(begin + wordlen * i, wordlen);
            if (map.containsKey(word)) {
                if (map.get(word) > 0) {
                    map.put(word, map.get(word) - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }


}
