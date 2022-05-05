/* https://leetcode-cn.com/problems/subarray-product-less-than-k/ */
public class s1 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int ni = nums[i];
            if (ni < k) {
                ans++;
                int multiple = ni;
                for (int j = i + 1; j < n; j++) {
                    multiple *= nums[j];
                    if (multiple < k) {
                        ans++;
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }

}
