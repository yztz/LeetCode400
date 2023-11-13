/* https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal/ */
public class s99 {

    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;
        int xy = 0;
        int yx = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            if (s1.charAt(i) == 'x') xy++;
            else yx++;
        }

        if ((xy + yx) % 2 == 1) return -1;

        return xy / 2 + yx / 2 + (xy % 2) * 2;
    }
}
