import java.util.Arrays;

public class Leetcode881 {

    public int numRescueBoats(int[] people, int limit) {

        int res = 0;
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        while (l < r) {
            if (people[l] + people[r] <= limit) {
                l++;
            }
            res++;
            r--;
        }
        return res + (l == r ? 1 : 0);
    }
}
