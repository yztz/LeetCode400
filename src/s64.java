import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* https://leetcode.cn/problems/replace-words/ */
public class s64 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Tree root = new Tree();
        for (String word : dictionary) {
            root.addWord(word);
        }
        String[] patterns = sentence.split(" ");
        for (int i = 0; i < patterns.length; i++) {
            Tree tmp = root;
            for(char c : patterns[i].toCharArray()) {
                tmp = tmp.children.getOrDefault(c, null);
                if (tmp == null || tmp.word != null) break;
            }
            if (tmp != null && tmp.word != null) {
                patterns[i] = tmp.word;
            }
        }

        return String.join(" ", patterns);

    }



    static class Tree {
        Map<Character, Tree> children = new HashMap<>();
        String word;

        void addWord(String word) {
            Tree root = this;
            for (char c : word.toCharArray()) {
                if(root.children.containsKey(c)) {
                    root = root.children.get(c);
                } else {
                    Tree tree = new Tree();
                    root.children.put(c, tree);
                    root = tree;
                }
            }
            root.word = word;
        }

    }
}
