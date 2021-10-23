public class Leetcode492 {

    public int[] constructRectangle(int area) {

        int start = (int) Math.sqrt(area);
        if (start * start < area) {
            start++;
        }
        for (int l = start; l <= area; l++) {

            if (area % l == 0) {
                return new int[] {l, area / l};
            }
        }
        return new int[] {area, 1};
    }
}
