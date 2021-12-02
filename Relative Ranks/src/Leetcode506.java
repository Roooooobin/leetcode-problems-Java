import java.util.Arrays;
import java.util.HashMap;

public class Leetcode506 {

    public String[] findRelativeRanks(int[] score) {

        HashMap<Integer, Integer> score2Idx = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            score2Idx.put(score[i], i);
        }
        String[] res = new String[score.length];
        Arrays.sort(score);
        for (int i = score.length - 1; i >= 0; i--) {
            if (i == score.length - 1) {
                res[score2Idx.get(score[i])] = "Gold Medal";
            } else if (i == score.length - 2) {
                res[score2Idx.get(score[i])] = "Silver Medal";
            } else if (i == score.length - 3) {
                res[score2Idx.get(score[i])] = "Bronze Medal";
            } else {
                res[score2Idx.get(score[i])] = score.length - i + "";
            }
        }
        return res;
    }
}
