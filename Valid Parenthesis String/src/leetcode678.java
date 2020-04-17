public class leetcode678 {
    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        int low = 0, high = 0;
        for(char c: chars){
            if(c == '('){
                low++;
                high++;
            }
            else if(c == '*'){
                low--;
                high++;
            }
            else{
                low--;
                high--;
            }
            if(high < 0) return false;  // 这个判断要及时，不能把后面的一起算进来，前面不行了就 false
            low = Math.max(0, low);
        }
        return low == 0;
    }

    public static void main(String[] args) {

    }
}
