/* https://leetcode.cn/problems/find-duplicate-subtrees/ */
import javafx.util.Pair;

import java.util.*;

public class s76 {
    int idx = 0;
    Map<String, Pair<TreeNode, Integer>> map = new HashMap<>();

    Set<TreeNode> set = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(set);
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int[] tri = new int[] { node.val, dfs(node.left), dfs(node.right)};
        String hash = Arrays.toString(tri);
        Pair<TreeNode, Integer> pair;
        if (map.containsKey(hash)) {
            pair = map.get(hash);
            set.add(pair.getKey());
        } else {
            pair = new Pair<>(node, ++idx);
            map.put(hash, pair);
        }
        return pair.getValue();
    }


}
