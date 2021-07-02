import java.util.Arrays;

public class Leetcode1833 {
    public static int maxIceCream(int[] costs, int coins) {

        int ans = 0;

        Arrays.sort(costs);
        for (int cost : costs) {
            if (coins < cost) {
                break;
            }
            ans++;
            coins -= cost;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] costs = new int[]{1, 3, 1};
        System.out.println(maxIceCream(costs, 0));
    }
}
