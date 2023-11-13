/* https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/ */
import java.util.Arrays;

public class s83 {
    public double trimMean(int[] arr) {
        int n = arr.length;
        int cut = n * 5 / 100;
        Arrays.sort(arr);
        int ans = 0;
        for (int i = cut; i < n - cut; i++) {
            ans += arr[i];
        }
        return (double) ans / (n - 2. * cut);
    }
}
