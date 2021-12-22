public class Leetcode1032 {

    class StreamChecker {

        Trie trie = new Trie();
        StringBuilder curWholeString = new StringBuilder();

        public StreamChecker(String[] words) {

            for (String word : words) {
                StringBuilder sb = new StringBuilder();
                sb.append(word);
                sb.reverse();
                trie.insert(sb.toString());
            }
        }

        public boolean query(char letter) {
            curWholeString.insert(0, letter);
            StringBuilder cur = new StringBuilder();
            for (int i = 0; i < curWholeString.length(); i++) {
                cur.append(curWholeString.charAt(i));
                String curString = cur.toString();
                if (!trie.startsWith(curString)) {
                    return false;
                } else {
                    if (trie.search(curString)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    class Trie {
        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); ++i) {
                char curChar = word.charAt(i);
                if (!node.containsKey(curChar)) {
                    node.put(curChar, new TrieNode());
                }
                node = node.get(curChar);
            }
            node.setEnd();
        }

        /** Returns if the word is in the trie. */
        public TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); ++i) {
                char curChar = word.charAt(i);
                if (!node.containsKey(curChar)) {
                    return null;
                } else {
                    node = node.get(curChar);
                }
            }
            return node;
        }

        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
    }

    class TrieNode {
        private TrieNode[] links;

        private final int R = 26; // letters a-z

        private boolean isEnd; // to denote whether the end of a word

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
