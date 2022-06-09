import java.util.*;
/* https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/ */
public class s36 {

    static class Solution {
        Random random = new Random();
        int[][] rects;
        List<Integer> list = new ArrayList<>();

        public Solution(int[][] rects) {
            this.rects = rects;
            list.add(0);
            for (int[] rect : rects) {
                int a = rect[0], b = rect[1], x = rect[2], y = rect[3];
                list.add((x - a + 1) * (y - b + 1) + list.get(list.size() - 1));
            }

        }

        public int[] pick() {
            int area = random.nextInt(list.get(list.size() - 1)) + 1;
            int idx = bs(area) - 1;
            int x = random.nextInt(rects[idx][2] - rects[idx][0] + 1) + rects[idx][0];
            int y = random.nextInt(rects[idx][3] - rects[idx][1] + 1) + rects[idx][1];


            return new int[]{x, y};
        }

        private int bs(int target) {
            int l = 0, r = list.size();
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (list.get(mid) >= target)
                    r = mid;
                else
                    l = mid + 1;
            }

            return r;
        }


    }
}
