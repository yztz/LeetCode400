import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s77 {

    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(-1);
                list.add(i);
                map.put(c, list);
            }
        }

        int ans = 0;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> pos = entry.getValue();
            pos.add(s.length());
            for (int i = 1; i < pos.size() - 1; i++) {
                ans += (pos.get(i) - pos.get(i - 1)) * (pos.get(i + 1) - pos.get(i));
            }
        }

        return ans;
    }
}
