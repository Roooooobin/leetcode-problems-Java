import java.util.HashSet;
import java.util.Set;

public class Leetcode202 {
    public boolean isHappy(int n) {
        Set<Integer> hash = new HashSet<>();
        hash.add(n);
        while(true){
            int x = 0;
            while(n != 0){
                x += (n % 10) * (n % 10);
                n /= 10;
            }
            n = x;
            if(n == 1) return true;
            if(hash.contains(n)) return false;
            else hash.add(n);
        }
    }
}
