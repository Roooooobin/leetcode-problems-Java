public class Leetcode1138 {

    public String alphabetBoardPath(String target) {

        // starts from 0, 0
        int curX = 0, curY = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int posX = (c - 'a') / 5, posY = (c - 'a') % 5;
            if (posY < curY) {
                res.append("L".repeat(curY - posY));
            }
            if (posX < curX) {
                res.append("U".repeat(curX - posX));
            }
            if (posY > curY) {
                res.append("R".repeat(posY - curY));
            }
            if (posX > curX) {
                res.append("D".repeat(posX - curX));
            }
            res.append("!");
            curX = posX;
            curY = posY;
        }
        return res.toString();
    }
}
