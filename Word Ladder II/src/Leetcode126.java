//import java.util.*;
//
//public class Leetcode126 {
//    // WA
//    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        HashSet<String> dictionary = new HashSet<>(wordList);
//        if (!dictionary.contains(endWord)) return new ArrayList<>();
//        HashSet<String> visited = new HashSet<>();
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//        visited.add(beginWord);
//        HashMap<String, String> backtrace = new HashMap<>();
//        backtrace.put(beginWord, "0");
//        List<List<String>> ans = new ArrayList<>();
//        while (true) {
//            int count = queue.size();
//            if (count == 0) break;;
//            while (count > 0) {
//                count--;
//                String cur = queue.poll();
//                visited.add(cur);
//                for (int i=0; i<cur.length(); ++i) {
//                    for (int j=0; j<26; ++j) {
//                        String newWord = cur.substring(0, i) + (char)(j + 'a') + cur.substring(i+1);
//                        if (dictionary.contains(newWord) && !visited.contains(newWord)) {
//                            queue.offer(newWord);
//                            if (newWord.equals(endWord)) {
//                                List<String> res = new ArrayList<>();
//                                res.add(endWord);
//                                res.add(cur);
//                                String last = backtrace.get(cur);
//                                while (!last.equals("0")) {
//                                    res.add(last);
//                                    last = backtrace.get(last);
//                                }
//                                Collections.reverse(res);
//                                ans.add(res);
//                            }
//                            else {
//                                visited.add(newWord);
//                                backtrace.put(newWord, cur);
//                            }
//                        }
//                    }
//                }
//            }
//            if (!ans.isEmpty()) {
//                return ans;
//            }
//        }
//        return new ArrayList<>();
//    }
    /*
        作者：liweiwei1419
        链接：https://leetcode-cn.com/problems/word-ladder-ii/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you--2/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Leetcode126 {

    class Solution {

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            // 先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
            Set<String> dictionary = new HashSet<>(wordList);
            List<List<String>> res = new ArrayList<>();
            if (dictionary.size() == 0 || !dictionary.contains(endWord)) {
                return res;
            }
            // 第 1 步：使用广度优先遍历得到后继结点列表 successors
            // key：字符串，value：广度优先遍历过程中 key 的后继结点列表
            Map<String, Set<String>> successors = new HashMap<>();
            boolean found = bfs(beginWord, endWord, dictionary, successors);
            if (!found) {
                return res;
            }
            // 第 2 步：基于后继结点列表 successors ，使用回溯算法得到所有最短路径列表
            Deque<String> path = new ArrayDeque<>();
            path.addLast(beginWord);
            dfs(beginWord, endWord, successors, path, res);
            return res;
        }

        private boolean bfs(String beginWord, String endWord, Set<String> wordSet,
                            Map<String, Set<String>> successors) {
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            // 记录访问过的单词
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);
            boolean found = false;
            int wordLen = beginWord.length();
            // 当前层访问过的结点，当前层全部遍历完成以后，再添加到总的 visited 集合里（关键）
            Set<String> nextLevelVisited = new HashSet<>();
            while (!queue.isEmpty()) {
                int currentSize = queue.size();
                for (int i = 0; i < currentSize; i++) {
                    String currentWord = queue.poll();
                    char[] charArray = currentWord.toCharArray();
                    for (int j = 0; j < wordLen; j++) {
                        char originChar = charArray[j];
                        for (char k = 'a'; k <= 'z'; k++) {
                            if (charArray[j] == k) {
                                continue;
                            }
                            charArray[j] = k;
                            String nextWord = new String(charArray);
                            if (wordSet.contains(nextWord)) {
                                if (!visited.contains(nextWord)) {
                                    if (nextWord.equals(endWord)) {
                                        found = true;
                                    }
                                    nextLevelVisited.add(nextWord);
                                    queue.offer(nextWord);

                                    // 维护 successors 的定义
                                    successors.computeIfAbsent(currentWord, a -> new HashSet<>());
                                    successors.get(currentWord).add(nextWord);
                                }
                            }
                        }
                        charArray[j] = originChar;
                    }
                }

                if (found) {
                    break;
                }
                visited.addAll(nextLevelVisited);
                nextLevelVisited.clear();
            }
            return found;
        }

        private void dfs(String beginWord, String endWord,
                         Map<String, Set<String>> successors,
                         Deque<String> path, List<List<String>> res) {
            if (beginWord.equals(endWord)) {
                res.add(new ArrayList<>(path));
                return;
            }
            if (!successors.containsKey(beginWord)) {
                return;
            }
            Set<String> successorWords = successors.get(beginWord);
            for (String nextWord : successorWords) {
                path.addLast(nextWord);
                dfs(nextWord, endWord, successors, path, res);
                path.removeLast();
            }
        }
    }
    public static void main(String[] args) {

    }
}