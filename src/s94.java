/* https://leetcode.cn/problems/reformat-phone-number/ */
public class s94 {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for (char c : number.toCharArray()) {
            if(c != ' ' && c != '-')
                sb.append(c);
        }
        int n = sb.length();
        int i = 0;
        while (i < n - 4){

            for (int j = i; j < i + 3; j++) {
                ans.append(sb.charAt(j));
            }
            ans.append('-');
            i += 3;
        }

        if(i < n) {
            if (n - i <= 3) {
                while (i < n) {
                    ans.append(sb.charAt(i++));
                }
            } else {
                ans.append(sb.substring(i, i + 2))
                        .append('-')
                        .append(sb.substring(i + 2, i + 4));
            }

        } else {
            ans.setLength(ans.length() - 1);
        }

        return ans.toString();
    }
}
