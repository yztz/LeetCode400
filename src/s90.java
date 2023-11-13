/* https://leetcode.cn/problems/defuse-the-bomb/ */
import java.util.Arrays;

public class s90 {

    public int[] decrypt(int[] code, int k) {
        if(k == 0) {
            Arrays.fill(code, 0);
            return code;
        }
        int n = code.length;
        int left = k > 0 ? 1 : n + k;
        int cnt = 0;
        k = Math.abs(k);
        for (int i = 0; i < k; i++) {
            cnt += code[(left + i) % n];
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = cnt;
            cnt -= code[left];
            left = (left + 1) % n;
            cnt += code[(left + k - 1) % n];
        }

        return ans;
    }

}
