/* https://leetcode.cn/problems/find-closest-lcci/ */
public class s23 {
    public int findClosest(String[] words, String word1, String word2) {
        int n = words.length;
        int pre = -1;
        boolean isWord1 = true;
        int ans = 100001;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(word1)) {
                if (pre == -1) {
                    pre = i;
                    isWord1 = true;
                } else {
                    if (!isWord1) {
                        isWord1 = true;
                        ans = Math.min(ans, i - pre);
                    }
                    pre = i;
                }
            } else if (words[i].equals(word2)) {
                if (pre == -1) {
                    pre = i;
                    isWord1 = false;
                } else {
                    if (isWord1) {
                        isWord1 = false;
                        ans = Math.min(ans, i - pre);
                    }
                    pre = i;
                }
            }
        }
        return ans;
    }
}
