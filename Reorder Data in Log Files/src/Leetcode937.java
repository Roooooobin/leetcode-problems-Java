import java.util.Arrays;
import java.util.Comparator;

public class Leetcode937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            int idxOfFirstChar1 = log1.indexOf(' ') + 1;
            int idxOfFirstChar2 = log2.indexOf(' ') + 1;
            boolean isDigit1 = Character.isDigit(log1.charAt(idxOfFirstChar1));
            boolean isDigit2 = Character.isDigit(log2.charAt(idxOfFirstChar2));
            // 字母log按照字典序排序
            if (!isDigit1 && !isDigit2) {
                String log1WithoutId = log1.substring(idxOfFirstChar1);
                String log2WithoutId = log2.substring(idxOfFirstChar2);
                int cmp = log1WithoutId.compareTo(log2WithoutId);
                if (cmp != 0) return cmp;
                else return log1.substring(0, idxOfFirstChar1-1).compareTo(log2.substring(0, idxOfFirstChar2-1));
            }
            // 字母log一定在数字log前面
            else return isDigit1 ? (isDigit2 ? 0: 1) : -1;
        });
        return logs;
    }

    class Solution {
        // 使用split分开
        public String[] reorderLogFiles(String[] logs) {
            Arrays.sort(logs, (log1, log2) -> {
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0) return cmp;
                    return split1[0].compareTo(split2[0]);
                }
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            });
            return logs;
        }
    }

    class Solution2 {
        // 使用自建的Comparator
        public String[] reorderLogFiles(String[] logs) {
            Comparator<String> myComparator = new Comparator<String>() {
                @Override
                public int compare(String log1, String log2) {
                    String[] split1 = log1.split(" ", 2);
                    String[] split2 = log2.split(" ", 2);
                    boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                    boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                    if (!isDigit1 && !isDigit2) {
                        int cmp = split1[1].compareTo(split2[1]);
                        if (cmp != 0) return cmp;
                        return split1[0].compareTo(split2[0]);
                    }
                    return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
                }
            };
            Arrays.sort(logs, myComparator);
            return logs;
        }
    }

    public static void main(String[] args) {
        System.out.println(Character.isDigit('9'));
    }
}
