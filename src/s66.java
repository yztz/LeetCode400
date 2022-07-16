/* https://leetcode.cn/problems/qIsx9U/ */
public class s66 {
    static class MovingAverage {
        int i;
        int size;
        int[] buf;
        int add;
        int cnt;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            this.buf = new int[size];
            this.i = this.cnt = 0;
        }

        public double next(int val) {
            add += val;
            if(cnt == size) {
                add -= buf[i];
                buf[i] = val;
            } else {
                buf[i] = val;
                cnt++;
            }
            i = (i + 1) % size;

            return add / (double)cnt;
        }
    }
}
