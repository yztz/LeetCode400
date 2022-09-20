/* https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/ */
import java.util.Arrays;

public class s87 {

    int per;
    int[] nums;

    boolean[] dp;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int add = 0;
        for (int num : nums) add += num;
        if (add % k != 0) return false;
        this.nums = nums;
        this.per = add / k;
        this.dp = new boolean[1 << nums.length];
        Arrays.sort(nums);
        Arrays.fill(dp, true);

        return dfs(0, 0);
    }


    private boolean dfs(int state, int per) {
        if (state == (1 << nums.length) - 1) return true;
        if (!dp[state]) return false;
        int[] nums = this.nums;

        dp[state] = false;

        for (int i = 0; i < nums.length; i++) {
            if (per + nums[i] > this.per)
                break;
            if ((state & (1 << i)) == 0) {
                if (dfs(state ^ (1 << i), (per + nums[i]) % this.per)) {
                    return true;
                }
            }
        }


        return false;
    }

}


