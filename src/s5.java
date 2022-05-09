/* https://leetcode.cn/problems/di-string-match/ */
public class s5 {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        int l = 0, r = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = l++;
            } else { // D
                ans[i] = r--;
            }
        }
        ans[n] = l;

        return ans;
    }
}
