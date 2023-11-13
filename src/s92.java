/* https://leetcode.cn/problems/missing-two-lcci/ */
public class s92 {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;

        int xory = 0;

        for (int i = 1; i <= n; i++) {
            xory ^= i;
        }

        for (int i = 0; i < nums.length; i++) {
            xory ^= nums[i];
        }

        int l = xory & -xory;

        int a = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & l) > 0) {
                a ^= i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if ((i & l) > 0) {
                a ^= nums[i];
            }
        }

        return new int[]{a, xory ^ a};


    }
}
