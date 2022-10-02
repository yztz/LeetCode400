/* https://leetcode.cn/problems/swap-adjacent-in-lr-string/ */\
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class s95 {

    public static void main(String[] args) {
        System.out.println(new s95().canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }

    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;
        Queue<Pair<Character, Integer>> queue = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < start.length(); i++) {
            char c = start.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (c != 'X') queue.offer(new Pair<>(c, i));
        }
        for (int i = 0; i < end.length(); i++) {
            char c = end.charAt(i);
            if(map.getOrDefault(c, 0) <= 0)
                return false;
            if(c != 'X') {
                if (queue.isEmpty()) return false;
                Pair<Character, Integer> pair = queue.poll();
                if (pair.getKey() != c) return false;
                int pos = pair.getValue();
                if (pair.getKey() == 'L' && pos < i || pair.getKey() == 'R' && pos > i) {
                    return false;
                }
            }
            map.put(c, map.get(c) - 1);
        }

        return map.getOrDefault('L', 0) == 0 &&
                map.getOrDefault('R', 0) == 0 &&
                map.getOrDefault('X', 0) == 0 &&
                queue.isEmpty();
    }
}
