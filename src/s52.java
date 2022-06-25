public class s52 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[] dp = new int[3];
        dp[0] = costs[0][0];
        dp[1] = costs[1][1];
        dp[2] = costs[2][2];
        for (int i = 1; i < n; i++) {
            int min01 = Math.min(dp[0], dp[1]);
            int min12 = Math.min(dp[2], dp[1]);
            int min02 = Math.min(dp[0], dp[2]);
            dp[0] = costs[i][0] + min12;
            dp[1] = costs[i][1] + min02;
            dp[2] = costs[i][2] + min01;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }
}
