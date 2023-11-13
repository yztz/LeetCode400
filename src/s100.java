/* https://leetcode.cn/problems/partition-array-into-disjoint-intervals/ */
public class s100 {

    public static void main(String[] args) {
        int[] nums = {24,11,49,80,63,8,61,22,73,85};
        new s100().partitionDisjoint(nums);
    }

    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int curMax, leftMax;
        curMax = leftMax = nums[0];

        int leftPos = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < leftMax) {
                leftPos = i;
                if (leftMax != curMax) leftMax = curMax;
            } else if (nums[i] > curMax){
                curMax = nums[i];
            }
        }

        return leftPos + 1;
    }
}
