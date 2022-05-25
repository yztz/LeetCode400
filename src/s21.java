import java.util.Arrays;
/* https://leetcode.cn/problems/unique-substrings-in-wraparound-string/ */
public class s21 {

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        int n = p.length();
        for (int i = 0; i < n; i++) {
            int ch = p.charAt(i) - 'a';
            if (i > 0 && (p.charAt(i - 1) - 'a' + 1) % 26 == ch) {
                k++;
            } else {
                k = 1;
            }
            dp[ch] = Math.max(dp[ch], k);
        }
        return Arrays.stream(dp).sum();
    }
}
