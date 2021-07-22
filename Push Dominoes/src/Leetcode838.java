import java.util.ArrayList;

public class Leetcode838 {

    public String pushDominoes(String dominoes) {

        StringBuilder res = new StringBuilder();
        int len = dominoes.length();
        ArrayList<Integer> idxOfLR = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            if (dominoes.charAt(i) == 'L' || dominoes.charAt(i) == 'R') {
                idxOfLR.add(i);
            }
        }
        if (idxOfLR.size() == 0) {
            return dominoes;
        }

        int idx0 = idxOfLR.get(0);
        if (dominoes.charAt(idx0) == 'L') {
            for (int i = 0; i < idx0; ++i) {
                res.append('L');
            }
        } else {
            for (int i = 0; i < idx0; ++i) {
                res.append(dominoes.charAt(i));
            }
        }

        for (int i = 1; i < idxOfLR.size(); ++i) {
            int idxPre = idxOfLR.get(i - 1);
            int idxCur = idxOfLR.get(i);
            char pre = dominoes.charAt(idxPre);
            char cur = dominoes.charAt(idxCur);
            if (cur != pre) {
                if (cur == 'R' && pre == 'L') {
                    for (int j = idxPre; j < idxCur; ++j) {
                        res.append(dominoes.charAt(j));
                    }
                } else {
                    int step = idxCur - idxPre;
                    if (step % 2 == 1) {
                        step /= 2;
                        for (int j = 0; j < step + 1; ++j) {
                            res.append('R');
                        }
                        for (int j = 0; j < step; ++j) {
                            res.append('L');
                        }
                    } else {
                        step = (step - 1) / 2;
                        for (int j = 0; j < step + 1; ++j) {
                            res.append('R');
                        }
                        res.append('.');
                        for (int j = 0; j < step; ++j) {
                            res.append('L');
                        }
                    }
                }
            } else {
                for (int j = idxPre; j < idxCur; ++j) {
                    res.append(cur);
                }
            }
        }

        int idxN = idxOfLR.get(idxOfLR.size() - 1);
        if (dominoes.charAt(idxN) == 'R') {
            for (int i = idxN; i < len; ++i) {
                res.append('R');
            }
        } else {
            for (int i = idxN; i < len; ++i) {
                res.append(dominoes.charAt(i));
            }
        }

        return res.toString();
    }
}
