import java.util.ArrayDeque;
import java.util.Deque;
/* https://leetcode.cn/problems/remove-outermost-parentheses/ */
public class s24 {
    public String removeOuterParentheses(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ')' ) {
                deque.pop();
            }
            if (!deque.isEmpty()) {
                sb.append(ch);
            }
            if (ch == '(') {
                deque.push(ch);
            }
        }
        return sb.toString();
    }
}
