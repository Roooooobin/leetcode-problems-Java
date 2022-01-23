import java.util.HashMap;
import java.util.TreeMap;

public class Leetcode2034 {

    //    class StockPrice {
    //
    //        TreeMap<Integer, Integer> record;
    //        HashMap<Integer, Integer> value2Count;
    //        PriorityQueue<Integer> maxValues;
    //        PriorityQueue<Integer> minValues;
    //
    //        public StockPrice() {
    //
    //            record = new TreeMap<>();
    //            value2Count = new HashMap<>();
    //            maxValues = new PriorityQueue<>((o1, o2) -> o2 - o1);
    //            minValues = new PriorityQueue<>();
    //        }
    //
    //        public void update(int timestamp, int price) {
    //            if (!record.containsKey(timestamp)) {
    //                record.put(timestamp, price);
    //            } else {
    //                int curPrice = record.get(timestamp);
    //                record.put(timestamp, price);
    //                int curMax = maxValues.peek();
    //                int curMin = minValues.peek();
    //
    //                if (curPrice == curMax) {
    //                    if (value2Count.get(curPrice) == 1) {
    //                        maxValues.remove(curPrice);
    //                        minValues.remove(curPrice);
    //                    }
    //
    //                } else if (curPrice == curMin) {
    //                    if (value2Count.get(curPrice) == 1) {
    //                        maxValues.remove(curPrice);
    //                        minValues.remove(curPrice);
    //                    }
    //                }
    //                value2Count.put(curPrice, value2Count.get(curPrice) - 1);
    //            }
    //            value2Count.put(price, value2Count.getOrDefault(price, 0) + 1);
    //            maxValues.add(price);
    //            minValues.add(price);
    //        }
    //
    //        public int current() {
    //            return record.lastEntry().getValue();
    //        }
    //
    //        public int maximum() {
    //            return maxValues.peek();
    //        }
    //
    //        public int minimum() {
    //            return minValues.peek();
    //        }
    //    }

    /*
    https://leetcode-cn.com/problems/stock-price-fluctuation/solution/gu-piao-jie-ge-bo-dong-by-leetcode-solut-rwrb/
     */
    class StockPrice {
        int maxTimestamp;
        HashMap<Integer, Integer> timePriceMap;
        TreeMap<Integer, Integer> prices;

        public StockPrice() {
            maxTimestamp = 0;
            timePriceMap = new HashMap<>();
            prices = new TreeMap<>();
        }

        public void update(int timestamp, int price) {
            maxTimestamp = Math.max(maxTimestamp, timestamp);
            int prevPrice = timePriceMap.getOrDefault(timestamp, 0);
            timePriceMap.put(timestamp, price);
            if (prevPrice > 0) {
                prices.put(prevPrice, prices.get(prevPrice) - 1);
                if (prices.get(prevPrice) == 0) {
                    prices.remove(prevPrice);
                }
            }
            prices.put(price, prices.getOrDefault(price, 0) + 1);
        }

        public int current() {
            return timePriceMap.get(maxTimestamp);
        }

        public int maximum() {
            return prices.lastKey();
        }

        public int minimum() {
            return prices.firstKey();
        }
    }
}
