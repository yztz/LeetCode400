import java.util.HashMap;
import java.util.Map;
/* https://leetcode.cn/problems/can-i-win/ */
public class s18 {
    Map<Integer, Boolean> mem = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int cnt = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if(cnt < desiredTotal) {
            return false;
        } else if (cnt == desiredTotal) {
            return maxChoosableInteger % 2 != 0;
        }

        return iwin(maxChoosableInteger, 0, desiredTotal, 0);
    }

    private boolean iwin(int max, int available, int target, int curr) {
        if(mem.containsKey(available))
            return mem.get(available);
        boolean res = false;
        for (int i = 0; i < max; i++) {
            if(((available >> i) & 1) == 0) {
                if (curr + i + 1 >= target || !iwin(max, available | (1 << i), target, curr + i + 1)) {
                    res = true;
                    break;
                }
            }
        }
        mem.put(available, res);
        return res;
    }
}
