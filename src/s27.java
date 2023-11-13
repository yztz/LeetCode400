/* https://leetcode.cn/problems/Jf1JuT/ TODO */
public class s27 {
    public String alienOrder(String[] words) {
        int[] bigger = new int[26];
        int[] smaller = new int[26];
        for (int i = 0; i < 26; i++) {
            bigger[i] = i;
            smaller[i] = i;
        }
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String s = words[i], b = words[j];
                if (s.equals(b)) {
                    if (j > i + 1) return "";
                    continue;
                }
                for (int k = 0; k < Math.min(s.length(), b.length()); k++) {
                    int l = s.charAt(k) - 'a';
                    int r = s.charAt(k) - 'a';
                    if(l != r) {
                        int t = bigger[l];
                        while (t != r) {
//                            t =
                        }
                        break;
                    }
                }

            }
        }
        return null;
    }
}
