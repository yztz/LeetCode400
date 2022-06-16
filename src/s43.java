import java.util.Arrays;
/* https://leetcode.cn/problems/k-diff-pairs-in-an-array/ */
public class s43 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int y = 1;
        int res = 0;
        for (int x = 0; x < n; x++) {
            if (x == 0 || nums[x] > nums[x - 1]) {
                while (y < n && nums[y] - nums[x] < k || y == x) {
                    y++;
                }
                if (y == n) {
                    break;
                } else if (nums[y] - nums[x] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
