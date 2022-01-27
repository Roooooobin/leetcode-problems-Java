public class Leetcode421 {

    /*
    https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-bmjdg/
     */
    class Solution {

        class TrieNode {
            TrieNode[] links = new TrieNode[2];
        }

        TrieNode root = new TrieNode();

        void addVal(int x) {

            TrieNode p = root;
            for (int i = 31; i >= 0; i--) {
                int u = (x >> i) & 1;
                if (p.links[u] == null) {
                    p.links[u] = new TrieNode();
                }
                p = p.links[u];
            }
        }

        int getVal(int x) {

            int res = 0;
            TrieNode p = root;
            for (int i = 31; i >= 0; i--) {
                int u = (x >> i) & 1;
                int w = 1 - u;
                if (p.links[w] != null) {
                    res |= (w << i);
                    p = p.links[w];
                } else {
                    res |= (u << i);
                    p = p.links[u];
                }
            }
            return res;
        }

        public int findMaximumXOR(int[] nums) {

            int res = 0;
            for (int x : nums) {
                addVal(x);
                int y = getVal(x);
                res = Math.max(res, x ^ y);
            }
            return res;
        }
    }
}
