import java.util.ArrayList;
import java.util.List;
/* https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/ */
public class s4 {

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
            if (nums[i] -1 != i) ans.add(nums[i]);
        }

        return ans;
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
