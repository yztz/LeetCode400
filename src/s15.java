import java.util.Arrays;
/* https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/ */
public class s15 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(mid - num);
        }

        return ans;
    }
}
