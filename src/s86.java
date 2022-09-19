/* https://leetcode.cn/problems/sort-array-by-increasing-frequency/ */
import java.util.*;

public class s86 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> n2f = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            int freq = n2f.getOrDefault(num, 0) + 1;
            n2f.put(num, freq);
        }


        Set<Integer> f = new HashSet<>(n2f.values());
        Integer[] freqs = f.toArray(new Integer[0]);
        Arrays.sort(freqs);

        Map<Integer, List<Integer>> f2n = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : n2f.entrySet()) {
            List<Integer> list = f2n.getOrDefault(entry.getKey(), new ArrayList<>());
            list.add(entry.getValue());
            f2n.put(entry.getKey(), list);
        }

        int[] ans = new int[n];
        int pos = 0;
        for (int freq : freqs) {
            List<Integer> num = f2n.get(freq);
            num.sort((a, b) -> b - a);
            for (Integer integer : num) for (int k = 0; k < freq; k++) ans[pos++] = integer;
        }

        return ans;
    }
}
