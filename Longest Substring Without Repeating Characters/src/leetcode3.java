public class leetcode3 {
    public static int lengthOfLongestSubstring(String s) {
        boolean[] hash = new boolean[128];
        int max = 0;
        int n = s.length();
        int i = 0, j = 0;
        while(i < n && j < n){
            if(!hash[s.charAt(j)]){
                max = Math.max(max, j-i+1);
                hash[s.charAt(j++)] = true;
            }
            else{
                hash[s.charAt(i++)] = false;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
