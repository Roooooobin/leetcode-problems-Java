public class Leetcode211 {

}

class TrieNode {
    private int R = 26;
    private TrieNode[] children;
    private boolean isWord = false;

    public TrieNode() {
        children = new TrieNode[R];
    }

    public boolean contains(char ch) {
        return children[ch - 'a'] != null;
    }

    public void setWord() {
        isWord = true;
    }

    public boolean isWord() {
        return isWord;
    }

    public void put(char ch) {
        children[ch - 'a'] = new TrieNode();
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }
}

class WordDictionary {

    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); ++i) {
            char curChar = word.charAt(i);
            if (!node.contains(curChar)) {
                node.put(curChar);
            }
            node = node.get(curChar);
        }
        node.setWord();
    }

    public boolean searchHelper(String word, int idx, TrieNode node) {
        if (idx == word.length()) return node.isWord();
        char ch = word.charAt(idx);
        TrieNode curNode = node;
        if (ch != '.') {
            if (!curNode.contains(ch)) {
                return false;
            }
            return searchHelper(word, idx+1, node.get(ch));
        }
        else {
            for (int i=0; i<26; ++i) {
                ch = (char) ('a' + i);
                if (curNode.contains(ch)) {
                    if (searchHelper(word, idx+1, node.get(ch))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
}
