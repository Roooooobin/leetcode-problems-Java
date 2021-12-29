import java.util.Arrays;

public class Leetcode1024 {

    public int videoStitching(int[][] clips, int time) {

        Arrays.sort(
                clips,
                (o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return o2[1] - o1[1];
                    } else {
                        return o1[0] - o2[0];
                    }
                });
        int n = clips.length;
        if (clips[0][0] != 0) {
            return -1;
        }
        int curFar = clips[0][1];
        int cur = 0;
        int idx = 0;
        int res = 0;
        while (cur < curFar) {
            res++;
            if (curFar >= time) {
                break;
            }
            int nextFar = curFar;
            while (idx < n) {
                if (clips[idx][0] <= curFar) {
                    nextFar = Math.max(nextFar, clips[idx][1]);
                } else {
                    break;
                }
                idx++;
            }
            cur = curFar;
            curFar = nextFar;
        }
        if (curFar < time) {
            return -1;
        }
        return res;
    }
}
