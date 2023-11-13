/* https://leetcode.cn/problems/check-array-formation-through-concatenation/ */
import java.util.HashMap;
import java.util.Map;

public class s88 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        int pos = 0;
        while (pos < arr.length){
            int target = arr[pos];
            if(map.containsKey(target)) {
                int[] piece = map.get(target);
                for (int num : piece) {
                    if (num == arr[pos]) pos++;
                    else return false;
                }
            } else {
                return false;
            }
        }
        return pos == arr.length;
    }
}
