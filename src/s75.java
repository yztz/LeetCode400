/* https://leetcode.cn/problems/special-positions-in-a-binary-matrix/ */
public class s75 {

    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] rc = new int[m];
        int[] cc = new int[n];

        for (int i = 0; i < m; i++) {
            int[] row = mat[i];
            for (int j = 0; j < n; j++) {
                rc[i] += row[j];
                cc[j] += row[j];
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if(rc[i] == 1) {
                int[] row = mat[i];
                for (int j = 0; j < n; j++) {
                    if(row[j] == 0) continue;
                    if(cc[j] == 1) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
