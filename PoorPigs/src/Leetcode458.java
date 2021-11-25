public class Leetcode458 {

    // solution by powcai in the comment section
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int res = 0;
        int maxTestBuckets = minutesToTest / minutesToDie + 1;
        // two pigs, two dimension cross test grid: maxTestBuckets * maxTestBuckets
        // if dead, the intersection is the poison
        // three pigs, three dimension
        int testedBuckets = 1;
        while (testedBuckets < buckets) {
            testedBuckets *= maxTestBuckets;
            res++;
        }
        return res;
    }
}
