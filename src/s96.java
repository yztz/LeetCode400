/* https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/ */
public class s96 {

    public boolean checkOnesSegment(String s) {
//        boolean flag = false;
//        boolean counting = false;
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '1') {
//                if (counting) continue;
//                if (flag) return false;
//                flag = true;
//                counting = true;
//            } else counting = false;
//        }
//
//        return true;

        return !s.contains("01");
    }
}
