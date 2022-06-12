import java.util.*;
/* https://leetcode.cn/problems/find-and-replace-pattern/ */
public class s38 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int n = pattern.length();
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            int[] p2w = new int[26];
            int[] w2p = new int[26];
            Arrays.fill(p2w, -1);
            Arrays.fill(w2p, -1);
            int i;
            for (i = 0; i < n; i++) {
                int p = pattern.charAt(i) - 'a';
                int w = word.charAt(i) - 'a';

                if (w2p[w] == -1 && p2w[p] == -1) {
                    w2p[w] = p;
                    p2w[p] = w;
                } else if (w2p[w] != p || p2w[p] != w){
                    break;
                }
                System.out.println(Arrays.toString(w2p));
                System.out.println(Arrays.toString(p2w));

            }

            if(i == n) {
                ans.add(word);
            }
        }
        return ans;
    }
}
