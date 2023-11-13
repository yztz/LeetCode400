/* https://leetcode.cn/problems/maximum-swap/ */
public class s82 {

    public int maximumSwap(int num) {
        String str = num + "";
        int n = str.length();
        if (n == 1) return num;

        char[] chs = str.toCharArray();
        for (int i = 0; i < n; i++) {
            char cur = chs[i];
            if(cur == '9') continue;
            int maxPos = -1;
            char max = cur;
            for (int j = i + 1; j < n; j++) {
                char target = chs[j];
                if(target >= max) {
                    max = target;
                    maxPos = j;
                }
            }
            if(maxPos != -1 && max != cur) {
                chs[i] = max;
                chs[maxPos] = cur;
                return Integer.parseInt(String.valueOf(chs));
            }
        }
        return num;
    }
}
