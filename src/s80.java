/* https://leetcode.cn/problems/crawler-log-folder/comments/ */
public class s80 {
    public int minOperations(String[] logs) {
        int depths = 0;
        for (String log : logs) {
            if("./".equals(log)) continue;
            if("../".equals(log)) {
                depths = Math.max(0, depths - 1);
            } else {
                depths++;
            }
        }
        return depths;
    }
}
