import java.util.Arrays;

/* https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/ */
public class s81 {

    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
//        int i = 0, j = n - 1;
//        while (i <= j) {
//            int mid = i + (j - i) / 2;
//            int x = n - mid;
//            if(nums[mid] >= x) {
//
//            }
//        }
        for(int i = 0; i < n; i++) {
            int x = n - i;
            if(nums[i] >= x) {
                if(i == 0 || nums[i - 1] < x) return x;
                else return -1;
            }
        }

        return -1;
    }
}
