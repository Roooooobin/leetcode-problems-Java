import java.util.*;

public class Leetcode71 {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pollLast();
            else if (!dir.equals("") && !dir.equals(".")) stack.offerLast(dir);
        }
        StringBuilder ans = new StringBuilder();
        for (String dir : stack) {
            ans.append("/").append(dir);
        }
        return ans.length() == 0 ? "/" : ans.toString();
    }

    // stack.pollLast() to avoid creating more Strings
    class Solution {
        public String simplifyPath(String path) {
            Deque<String> stack = new LinkedList<>();
            for(String s: path.split("/")){
                if(s.equals("..") ) stack.poll();
                else if(!s.equals("") && !s.equals(".")) stack.push(s);
            }
            StringBuilder sb = new StringBuilder();
            if(stack.size() == 0) return "/";
            while(stack.size() != 0) sb.append("/").append(stack.pollLast());
            return sb.toString();
        }
    }
}
