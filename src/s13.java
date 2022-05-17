import java.util.Comparator;
/* https://leetcode.cn/problems/verifying-an-alien-dictionary/ */
public class s13 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] ord = new int[26];
        for (int i = 0; i < 26; i++) {
            ord[order.charAt(i) - 'a'] = i;
        }
        Comparator<String> comparator = (a,b)->{
            for (int i = 0; i < a.length() && i < b.length(); i++) {
                int ca = a.charAt(i) - 'a', cb = b.charAt(i) - 'a';
                if (ord[ca] == ord[cb]) continue;
                return ord[ca] - ord[cb];
            }
            return a.length() - b.length();
        };
        for (int i = 1; i < words.length; i++) {
            if (comparator.compare(words[i - 1], words[i]) > 0) {
                return false;
            }
        }
        return true;
    }

}
