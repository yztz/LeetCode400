/* https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/ */
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class s98 {

    public int minSwap(int[] nums1, int[] nums2) {
        return dfs(0, false, nums1, nums2);
    }

    Map<Pair<Integer, Boolean>, Integer> map = new HashMap<>();

    public int dfs(int i, boolean swap, int[] nums1, int[] nums2) {
        int ans = swap ? 1 : 0;

        if (i == nums1.length) {
            return ans;
        }

        Pair<Integer, Boolean> pair = new Pair<>(i, swap);

        if (map.containsKey(pair)) {
            return map.get(pair);
        }

        if (i == 0) {
            ans = Math.min(dfs(1, true, nums1, nums2),
                    dfs(1, false, nums1, nums2));
        } else {
            int cnt = Integer.MAX_VALUE;
            if (swap) {
                if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                    cnt = Math.min(cnt, dfs(i + 1, false, nums1, nums2));
                }
                if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                    cnt = Math.min(cnt, dfs(i + 1, true, nums1, nums2));
                }
            } else {
                if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                    cnt = Math.min(cnt, dfs(i + 1, false, nums1, nums2));
                }
                if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                    cnt = Math.min(cnt, dfs(i + 1, true, nums1, nums2));
                }
            }
            ans += cnt;
        }

        map.put(new Pair<>(i, swap), ans);

        return ans;
    }

}
