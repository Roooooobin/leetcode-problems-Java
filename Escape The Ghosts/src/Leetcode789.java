public class Leetcode789 {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {

        // ...有点无语，感觉dfs有点没头绪，瞄了一眼标签，居然是数学，我就知道不太对劲了
        int playerStep = calcManhattanDistance(target, new int[] {0, 0});
        for (int[] ghost : ghosts) {
            if (calcManhattanDistance(target, ghost) <= playerStep) {
                return false;
            }
        }
        return true;
    }

    public int calcManhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
