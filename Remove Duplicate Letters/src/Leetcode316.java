public class Leetcode316 {
    public String removeDuplicateLetters(String s) {
        // 记录字母出现次数
        int[] letterCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letterCount[s.charAt(i) - 'a']++;
        }

        // 只能出现一次，记录是否已经存在
        boolean[] visited = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!visited[cur - 'a']) {
                // 比当前大
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > cur) {
                    char top = sb.charAt(sb.length() - 1);
                    // 还能删除
                    if (letterCount[top - 'a'] > 0) {
                        visited[top - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                visited[cur - 'a'] = true;
                sb.append(cur);
            }
            letterCount[cur - 'a'] -= 1;
        }
        return sb.toString();
    }
}
