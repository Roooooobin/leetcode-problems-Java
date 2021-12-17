public class Leetcode1518 {

    public int numWaterBottles(int numBottles, int numExchange) {

        int res = numBottles;
        while (numBottles >= numExchange) {
            int bottle = numBottles / numExchange;
            res += bottle;
            numBottles = numBottles % numExchange + bottle;
        }
        return res;
    }
}
