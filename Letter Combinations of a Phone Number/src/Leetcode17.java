import java.util.ArrayList;
import java.util.List;

public class Leetcode17 {

    private static final String[] NUM_LETTER = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void solve(String cur, String digits, int index, List<String> ans){
        if(index >= digits.length()){
            ans.add(cur);
            return;
        }
        String letters = NUM_LETTER[digits.charAt(index) - '0'];
        for(int i=0; i<letters.length(); ++i){
            solve(cur+letters.charAt(i), digits, index+1, ans);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0) return ans;
        solve("", digits, 0, ans);
        return ans;
    }

    public static void main(String[] args) {
        String digits = "23";
        ArrayList<String> res = new ArrayList<>();
        res = (ArrayList<String>) letterCombinations(digits);
        System.out.println(res);
    }

}
