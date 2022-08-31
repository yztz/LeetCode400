import java.util.*;
/* https://leetcode.cn/problems/validate-stack-sequences/ */
public class s71 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int i = 0, j = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        while (i < n) {
            int num = pushed[i++];
            if(num == popped[j]) {
                j++; continue;
            }
            while (!stack.isEmpty() && set.contains(popped[j])) {
                if(stack.pop() != popped[j]){
                    return false;
                }
                j++;
            }
            stack.push(num);
            set.add(num);
        }

        while (j < n) {
            if(stack.pop() != popped[j]) return false;
            j++;
        }
        return true;
    }
}
