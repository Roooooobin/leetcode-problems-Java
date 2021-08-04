import java.util.List;

public class Leetcode648 {

    class Solution {
        class TrieNode {

            private TrieNode[] links;
            private final int Len = 26;
            private boolean isEnd;

            TrieNode() {
                links = new TrieNode[Len];
            }

            public boolean isEnd() {
                return isEnd;
            }

            public void setEnd() {
                this.isEnd = true;
            }

            public void put(char c, TrieNode node) {
                links[c - 'a'] = node;
            }

            public TrieNode get(char c) {
                return links[c - 'a'];
            }

            public boolean containKey(char c) {
                return links[c - 'a'] != null;
            }
        }

        private TrieNode root;

        public void addWord(String word) {

            TrieNode node = root;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (!node.containKey(c)) {
                    node.put(c, new TrieNode());
                } else {
                    if (node.isEnd()) {
                        return;
                    }
                }
                node = node.get(c);
            }
            node.setEnd();
        }

        public String getPrefix(String word) {

            TrieNode node = root;
            // 寻找前缀，找得到返回，找不到返回原词
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                sb.append(c);
                if (!node.containKey(c)) {
                    return word;
                }
                node = node.get(c);
                if (node.isEnd()) {
                    return sb.toString();
                }
            }
            return word;
        }

        public String replaceWords(List<String> dictionary, String sentence) {

            root = new TrieNode();
            for (String word : dictionary) {
                addWord(word);
            }

            String[] words = sentence.split(" ");
            String[] prefixes = new String[words.length];
            for (int i = 0; i < words.length; i++) {
                prefixes[i] = getPrefix(words[i]);
            }
            return String.join(" ", prefixes);
        }
    }
}
