public class s14 {
    public int findKthNumber(int m, int n, int k) {
        if (m > n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        int cnt = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= n; j++) {
                int num = i * j;
                cnt += (j > i && j <= m) ? 2 : 1;
                System.out.println("num is " + num + " cnt add " + ((j > i && j <= m) ? 2 : 1));
                if (cnt >= k) return num;
            }
        }

        return -1;
    }
}
