public class Leetcode334 {

    // [0 4 1 -1 2] 75/76 TAT
    //    class Solution {
    //        public boolean increasingTriplet(int[] a) {
    //
    //            int x = 0, y = 0;
    //            boolean firstFlag = true;
    //            for (int i = 0; i < a.length - 1; i++) {
    //                if (a[i] < a[i + 1]) {
    //                    if (firstFlag) {
    //                        x = a[i];
    //                        y = a[i + 1];
    //                        firstFlag = false;
    //                    } else {
    //                        if (a[i] > x) {
    //                            return true;
    //                        } else if (a[i + 1] > y) {
    //                            return true;
    //                        } else if (a[i] < x) {
    //                            x = a[i];
    //                            y = a[i + 1];
    //                        }
    //                    }
    //                }
    //            }
    //            return false;
    //        }
    //    }

    class Solution {
        public boolean increasingTriplet(int[] a) {

            int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
            for (int v : a) {
                if (v <= x) {
                    x = v;
                } else if (v <= y) {
                    y = v;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
