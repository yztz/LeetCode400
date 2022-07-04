import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* https://leetcode.cn/problems/minimum-absolute-difference/ */
public class s61 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int delta = arr[i + 1] - arr[i];
            if (delta < min) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.clear();
                min = delta;
                ans.add(pair);
            } else if (delta == min) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            }
        }

        return ans;
    }
}
