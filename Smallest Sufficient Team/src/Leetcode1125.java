import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode1125 {

    // TLE, too slow when handling bitmask dp
    //    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
    //
    //        final int MAX = 0x3f3f3f3f;
    //        int n = req_skills.length;
    //        HashMap<String, Integer> skill2IdxMap = new HashMap<>();
    //        for (int i = 0; i < n; i++) {
    //            skill2IdxMap.put(req_skills[i], i);
    //        }
    //        HashMap<Integer, Integer> skillMask2IdxMap = new HashMap<>();
    //        for (int i = 0; i < people.size(); i++) {
    //            int mask = 0;
    //            for (String s : people.get(i)) {
    //                mask += (1 << skill2IdxMap.get(s));
    //            }
    //            skillMask2IdxMap.put(mask, i);
    //        }
    //
    //        int m = 1 << n;
    //        ArrayList<Integer>[] dp = new ArrayList[m];
    //        for (int i = 0; i < m; i++) {
    //            dp[i] = new ArrayList<>();
    //            if (skillMask2IdxMap.containsKey(i)) {
    //                dp[i].add(skillMask2IdxMap.get(i));
    //            }
    //        }
    //        for (int i = 1; i < m; i++) {
    //            if (dp[i].size() == 1) {
    //                continue;
    //            }
    //            for (int j = i; j > 0; j = (j - 1) & i) {
    //                if (dp[j].size() == 0) {
    //                    continue;
    //                }
    //                for (int k = 1; k < j; k++) {
    //                    if ((k | j) != i || dp[k].size() == 0) {
    //                        continue;
    //                    }
    //                    int lenI = dp[i].size(), lenJ = dp[j].size(), lenK = dp[k].size();
    //                    if (lenI == 0) {
    //                        lenI = MAX;
    //                    }
    //                    if (lenI > lenJ + lenK) {
    //                        ArrayList<Integer> newList = new ArrayList<>(dp[j]);
    //                        newList.addAll(dp[k]);
    //                        dp[i] = newList;
    //                    }
    //                }
    //            }
    //        }
    //
    //        int[] res = new int[dp[m - 1].size()];
    //        for (int i = 0; i < res.length; i++) {
    //            res[i] = dp[m - 1].get(i);
    //        }
    //
    //        return res;
    //    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        int n = req_skills.length, np = people.size();
        HashMap<String, Integer> skill2IdxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skill2IdxMap.put(req_skills[i], i);
        }
        // 预处理每个人的bit mask
        int[] peopleMasks = new int[np];
        for (int i = 0; i < np; i++) {
            int mask = 0;
            for (String s : people.get(i)) {
                mask += (1 << skill2IdxMap.get(s));
            }
            peopleMasks[i] = mask;
        }

        int m = 1 << n;
        int[] dp = new int[m];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int[] preState = new int[m];
        int[] preIdx = new int[m];
        for (int i = 0; i < np; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (dp[j] == -1) {
                    continue;
                }
                int state = j | peopleMasks[i];
                if (dp[state] == -1 || dp[state] > dp[j] + 1) {
                    dp[state] = dp[j] + 1;
                    // 追踪上一个state，用来得到链路上每个state
                    preState[state] = j;
                    // 用来追踪对应state下people的下标
                    preIdx[state] = i;
                }
            }
        }
        ArrayList<Integer> l = new ArrayList<>();
        int state = m - 1;
        while (state != 0) {
            l.add(preIdx[state]);
            state = preState[state];
        }

        int[] res = new int[l.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = l.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Leetcode1125 ins = new Leetcode1125();
        List<List<String>> l = new ArrayList<>();
        ArrayList<String> l1 = new ArrayList<>();
        //        l1.add("algorithms");
        //        l1.add("math");
        //        l1.add("java");
        l1.add("vaostwmycy");
        l.add(l1);
        ArrayList<String> l2 = new ArrayList<>();
        //        l2.add("algorithms");
        //        l2.add("math");
        //        l2.add("reactjs");
        l2.add("mgdipkgt");
        l.add(l2);
        ArrayList<String> l3 = new ArrayList<>();
        //        l3.add("java");
        //        l3.add("csharp");
        l3.add("bjwxnfbbubpnd");
        //        l3.add("aws");
        l.add(l3);
        ArrayList<String> l4 = new ArrayList<>();
        //        l4.add("math");
        //        l4.add("csharp");
        l4.add("uhppib");
        l.add(l4);
        //        ArrayList<String> l5 = new ArrayList<>();
        //        l5.add("aws");
        //        l5.add("java");
        //        l.add(l5);
        //        ins.smallestSufficientTeam(
        //                new String[] {"algorithms", "math", "java", "reactjs", "csharp", "aws"},
        // l);
        ins.smallestSufficientTeam(
                new String[] {"uhppib", "mgdipkgt", "vaostwmycy", "bjwxnfbbubpnd"}, l);
    }
}
