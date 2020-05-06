public class Leetcode69 {
//    public int mySqrt(int x) {
//        return (int)Math.sqrt(x);
//    }

    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        int mid;
        while(l <= r){
            mid = l + (r - l) / 2;
            if(mid <= x / mid){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Leetcode69 leetcode69 = new Leetcode69();
        System.out.println(leetcode69.mySqrt(1));
    }
}
