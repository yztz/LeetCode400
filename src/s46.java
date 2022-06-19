import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* https://leetcode.cn/problems/most-frequent-subtree-sum/ */
public class s46 {
    int maxCnt = 0;
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int val = dfs(root.left) + dfs(root.right) + root.val;
        int cnt = map.getOrDefault(val, 0) + 1;
        if(cnt > maxCnt) {
            maxCnt = cnt;
            ans.clear();
            ans.add(val);
        } else if (cnt == maxCnt) {
            ans.add(val);
        }
        map.put(val, cnt);
        return val;
    }
}
