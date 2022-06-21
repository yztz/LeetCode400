/* https://leetcode.cn/problems/add-two-integers/ */
public class s48 {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder(22);
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if(c == '.') sb.append("[.]");
            else sb.append(c);
        }
        return sb.toString();
    }
}
