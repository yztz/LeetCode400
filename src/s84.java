/* https://leetcode.cn/problems/largest-substring-between-two-equal-characters/ */
import java.util.Arrays;

public class s84 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] pos = new int[26];
        Arrays.fill(pos, -1);

        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if(pos[c] == -1) {
                pos[c] = i;
            } else {
                ans = Math.max(ans, i - pos[c] - 1);
            }
        }
        return ans;
    }
}
