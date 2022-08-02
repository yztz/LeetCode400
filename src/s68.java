public class s68 {

    static String pre[] = {
            "a", // 0
            "aa", // 1
            "aaaa", // 2
            "aaaaaaaa", // 3
            "aaaaaaaaaaaaaaaa", // 4
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", // 5
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", // 6
    };

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder(n);
        int t = n;
        for(int i = pre.length - 1; i >= 0; i--) {
            int pow = 1 << i;
            while (t >= pow) {
                sb.append(pre[i]);
                t -= pow;
            }
        }
        if(n % 2 == 0) {
            sb.setCharAt(n - 1, 'b');
        }

        return sb.toString();
    }


}
