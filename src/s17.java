import java.util.Random;
/* https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/ */
public class s17 {
    public int repeatedNTimes(int[] nums) {
        Random random = new Random();
        int n = nums.length;
        int i = 0;
        while (true) {
            i = (i + 1) % n;
            int j;
            while (i == (j = random.nextInt(n)));
            if(nums[i] == nums[j]) return nums[i];
         }
    }
}
