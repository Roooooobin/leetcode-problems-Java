public class Leetcode201 {
    public int rangeBitwiseAnd(int m, int n) {
        while(m < n){
            n &= (n - 1);
        }
        return n;
    }
}
