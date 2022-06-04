import java.util.HashSet;
import java.util.Set;
/* https://leetcode.cn/problems/unique-email-addresses/ */

public class s31 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] patterns = email.split("@");
            String local = patterns[0];
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < local.length(); i++) {
                char c = local.charAt(i);
                if (c == '+') {
                    break;
                }
                if (c == '.') {
                    continue;
                }
                sb.append(c);
            }
            set.add(sb.append('@').append(patterns[1]).toString());
        }
        return set.size();
    }
}
