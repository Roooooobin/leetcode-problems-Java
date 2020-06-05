import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode763 {
    public static List<Integer> partitionLabels(String S) {
        int[] lastPosition = new int[26];
        for (int i=0; i<S.length(); ++i) {
            lastPosition[S.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int curLast = 0;    // 目前最远的
        int pos = 0;    // 因为答案是每一段的长度, 所以设置pos记录每一段的头下标
        for (int i=0; i<S.length(); ++i) {
            curLast = Math.max(curLast, lastPosition[S.charAt(i) - 'a']);
            if (i == curLast) {
                ans.add(i - pos + 1);
                pos = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        partitionLabels("ababcbacadefegdehijhklij");

    }
}
