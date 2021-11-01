package leetcode.q1032;

public class Trie1 {
    private StringBuilder buffer;
    private TrieNode root;
    public Trie1(String[] words) {
        this.buffer = new StringBuilder();
        this.root = new TrieNode(); 
        buildTrie(words);
    }

    public boolean query(char letter) {
        this.buffer.append(letter);
        return isCommonSuffixExist(this.buffer.toString());
    }

    private boolean isCommonSuffixExist(String s) {
        TrieNode cur = this.root;
        for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
            TrieNode next = cur.children[c - 'a'];
            if (next != null) {
                if (next.isWord) {
                    return true;
                }
                cur = next;
            } else {
                return false;
            }
        }
        return cur.isWord;
    }

    private void buildTrie(String[] words) {
        for (String s : words) {
            addToTrie(s);
        }
    }

    private void addToTrie(String s) {
        TrieNode cur = root;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            TrieNode next = cur.children[c - 'a'];
            if (next == null) {
                next = new TrieNode();
                cur.children[c - 'a'] = next;
            }
            cur = next;
        }
        cur.isWord = true;
    }

    private static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
}
