/* https://leetcode.cn/problems/validate-ip-address/ */
public class s25 {
    public String validIPAddress(String queryIP) {
        if (queryIP.length() == 0 || queryIP.contains(":") && queryIP.contains("."))
            return "Neither";
        if (queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length() - 1) == ':')
            return "Neither";
        if (queryIP.charAt(0) == '.' || queryIP.charAt(queryIP.length() - 1) == '.')
            return "Neither";
        String[] pattern = queryIP.split("[:.]");
        if (pattern.length == 4) { // IPV4
            for (String p : pattern) {
                if (p.length() == 0 || p.startsWith("0") && p.length() != 1) return "Neither";
                int num = 0;
                for (char c : p.toCharArray()) {
                    if (!Character.isDigit(c)) return "Neither";
                    num = num * 10 + c - '0';
                    if (num > 255) return "Neither";
                }
            }
            return "IPv4";
        } else if (pattern.length == 8) { // IPV6
            for (String p : pattern) {
                if (p.length() == 0 || p.length() > 4) return "Neither";
                for (char c : p.toCharArray()) {
                    if (!Character.isDigit(c) && (c < 'a' || c > 'f') && (c < 'A' || c > 'F')) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        } else {
            return "Neither";
        }
    }
}
