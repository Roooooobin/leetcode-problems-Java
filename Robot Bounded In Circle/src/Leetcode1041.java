public class Leetcode1041 {

    class Solution {
        public boolean isRobotBounded(String instructions) {

            int[][] directions = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
            int x = 0, y = 0;
            int direction = 0; // 最开始是向北
            for (int i = 0; i < instructions.length(); i++) {
                char c = instructions.charAt(i);
                if (c == 'L') {
                    direction = (direction + 1) % 4;
                } else if (c == 'R') {
                    direction = (direction + 3) % 4;
                } else {
                    x = x + directions[direction][0];
                    y = y + directions[direction][1];
                }
            }
            // 一轮之后。回到(0,0)或者朝向不是北，那么一定能回到(0,0)
            return (x == 0 && y == 0) || direction > 0;
        }
    }
}
