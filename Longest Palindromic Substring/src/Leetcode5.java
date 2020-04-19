public class Leetcode5 {
    /*
    dp(i, j) represents whether s(i ... j) can form a palindromic substring, dp(i, j) is true
    when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring. When we found a palindrome,
    check if it's the longest one. Time complexity O(n^2).
     */
    public static String longestPalindrome1(String s) {
        int n = s.length();
        String ans = "";
        boolean[][] dp = new boolean[n][n];
        for(int i=n-1; i>=0; --i){
            for(int j=i; j<n; ++j){
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && ((j - i < 3) || (dp[i+1][j-1]));
                if(dp[i][j] && (ans.length() < j-i+1)){
                    ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    }

    public static String longestPalindrome2(String s) {
        int n = s.length();
        String ans = "";
        for(int i=0; i<n;){
            if(n - i <= ans.length() / 2) break;    // trim
            int k = i;
            while(k+1 < n && s.charAt(k) == s.charAt(k+1)) k++;
            int j = i;
            i = k + 1;
            while(j > 0 && k < n-1 && s.charAt(j-1) == s.charAt(k+1)){
                j--;
                k++;
            }
            if(k-j+1 > ans.length()){
                ans = s.substring(j, k+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome1("abcbcbaaa"));
        System.out.println(longestPalindrome2("abcbcbaaa"));
    }
}
