/* https://leetcode.cn/problems/flip-string-to-monotone-increasing/ */
public class s39 {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] dp = new int[2];

        for (int i = 0; i < n; i++) {
            int p0 = dp[0], p1 = dp[1];
            dp[0] = p0 + (s.charAt(i) == '0' ? 0 : 1);
            dp[1] = Math.min(p0, p1) + (s.charAt(i) == '0' ? 1 : 0);
        }

        return Math.min(dp[0], dp[1]);
    }
}
