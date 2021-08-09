import java.util.ArrayList;

public class Leetcode6 {

    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }
        ArrayList<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean isGoingDown = false;
        // 按照z字形模拟，遇到第一行或最后一行就转弯，填到相应行上
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                isGoingDown = !isGoingDown;
            }
            curRow += isGoingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
