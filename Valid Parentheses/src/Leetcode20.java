import java.util.Stack;

public class Leetcode20 {
    public static boolean isValid(String s) {
        int[] hash = new int[128];
        hash['('] = 1;
        hash[')'] = -1;
        hash['{'] = 2;
        hash['}'] = -2;
        hash['['] = 3;
        hash[']'] = -3;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            if(stack.empty() || hash[stack.peek()] + hash[c] != 0){
                stack.push(c);
            }
            else if(hash[stack.peek()] + hash[c] == 0){
                stack.pop();
            }
        }
//        System.out.println(stack);
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "(){}{[]}";
        System.out.println(isValid(s));
    }
}
