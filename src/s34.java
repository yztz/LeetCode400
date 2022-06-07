import java.util.Arrays;
/* https://leetcode.cn/problems/koko-eating-bananas/ */
public class s34 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        while (l < r) {
            int speed = (r - l) / 2 + l;
            if (getTime(piles, speed) > h) {
                l = speed + 1;
            } else {
                r = speed;
            }
        }
        return l;
    }

    private int getTime(int[] piles, int speed) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed;
        }
        return time;
    }
}
