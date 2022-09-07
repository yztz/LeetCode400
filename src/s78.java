import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode.cn/problems/rearrange-spaces-between-words/ */
public class s78 {
    public String reorderSpaces(String text) {
        int spaceCnt = 0;
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else {
                if (sb.length() != 0) {
                    words.add(sb.toString());
                    sb.setLength(0);
                }
                spaceCnt++;
            }
        }
        if (sb.length() != 0) words.add(sb.toString());
        sb.setLength(0);

        int wordCnt = words.size();
        if (wordCnt == 1) {
            sb.append(words.get(0));
            for (int i = 0; i < spaceCnt; i++) sb.append(' ');
            return sb.toString();
        }

        int gapCnt = spaceCnt / (wordCnt - 1);
        int more = spaceCnt - (wordCnt - 1) * gapCnt;
        char[] array = new char[gapCnt];
        Arrays.fill(array, ' ');
        String gap = new String(array);
        int i;
        for (i = 0; i < wordCnt - 1; i++) {
            sb.append(words.get(i));
            sb.append(gap);
        }
        sb.append(words.get(i));

        for (i = 0; i < more; i++) sb.append(' ');

        return sb.toString();
    }
}
