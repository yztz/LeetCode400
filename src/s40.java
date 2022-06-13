import java.util.Arrays;
/* https://leetcode.cn/problems/height-checker/ */
public class s40 {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] copy = new int[n];
        System.arraycopy(heights, 0, copy, 0, n);
        Arrays.sort(copy);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (copy[i] != heights[i]) ans++;
        }
        return ans;
    }
}
