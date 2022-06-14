/* https://leetcode.cn/problems/diagonal-traverse/ */
public class s41 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int idx = 0;

        for (int t = 0; t < m + n - 1; t++) {
            int delta, i, j;
            if (t % 2 == 0) { // even
                delta = 1;
                if (t < m) {
                    i = t;
                    j = 0;
                } else {
                    i = m - 1;
                    j = t - i;
                }
            } else { // odd
                delta = -1;
                if (t < n) {
                    i = 0;
                    j = t;
                } else {
                    j = n - 1;
                    i = t - j;
                }
            }
            while (i >= 0 && j >= 0 && i < m && j < n) {
                ans[idx++] = mat[i][j];
                i-=delta;
                j+=delta;
            }
        }

        return ans;
    }
}
