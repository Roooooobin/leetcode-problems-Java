import java.util.ArrayList;

public class Leetcode473 {

    // TLE
    //    public boolean makesquare(int[] matchsticks) {
    //
    //        int sum = 0;
    //        for (int matchstick : matchsticks) {
    //            sum += matchstick;
    //        }
    //        if (sum % 4 != 0) {
    //            return false;
    //        }
    //        int edgeLen = sum / 4;
    //        int k = 4;
    //        ArrayList<Integer> sticks = new ArrayList<>();
    //        for (int matchstick : matchsticks) {
    //            if (matchstick > edgeLen) {
    //                return false;
    //            }
    //            if (matchstick == edgeLen) {
    //                k--;
    //                continue;
    //            }
    //            sticks.add(matchstick);
    //        }
    //        // sticks中的数需要组成k个长度为edgeLen的边
    //        return dfs(sticks, k, edgeLen);
    //    }
    //
    //    public boolean dfs(ArrayList<Integer> candidates, int k, int tar) {
    //
    //        if (k == 0 || candidates.size() == 0) {
    //            return true;
    //        }
    //        int cur = candidates.get(0);
    //        for (int i = 1; i < candidates.size(); i++) {
    //            ArrayList<Integer> newCandidates = new ArrayList<>();
    //            int v = candidates.get(i);
    //            if (cur + v == tar) {
    //
    //                for (int j = 1; j < candidates.size(); j++) {
    //                    if (i != j) {
    //                        newCandidates.add(candidates.get(j));
    //                    }
    //                }
    //                if (dfs(newCandidates, k - 1, tar)) {
    //                    return true;
    //                }
    //            } else if (cur + v < tar) {
    //                for (int j = 1; j < candidates.size(); j++) {
    //                    if (i != j) {
    //                        newCandidates.add(candidates.get(j));
    //                    }
    //                }
    //                newCandidates.add(cur + v);
    //                if (dfs(newCandidates, k, tar)) {
    //                    return true;
    //                }
    //            }
    //        }
    //        return false;
    //    }

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int edgeLen = sum / 4;
        int k = 4;
        ArrayList<Integer> sticks = new ArrayList<>();
        for (int matchstick : matchsticks) {
            if (matchstick > edgeLen) {
                return false;
            }
            if (matchstick == edgeLen) {
                k--;
                continue;
            }
            sticks.add(matchstick);
        }
        int[] tar = new int[k];
        // sticks中的数需要组成k个长度为edgeLen的边
        return dfs(sticks, edgeLen, tar, 0);
    }

    public boolean dfs(ArrayList<Integer> a, int edgeLen, int[] tar, int idx) {

        if (idx == a.size()) {
            return isSquare(tar, edgeLen);
        }
        int v = a.get(idx);
        for (int k = 0; k < tar.length; k++) {
            if (tar[k] + v <= edgeLen) {
                tar[k] += v;
                if (dfs(a, edgeLen, tar, idx + 1)) {
                    return true;
                }
                tar[k] -= v;
            }
        }
        return false;
    }

    public boolean isSquare(int[] tar, int edgeLen) {

        for (int x : tar) {
            if (x != edgeLen) {
                return false;
            }
        }
        return true;
    }
}
