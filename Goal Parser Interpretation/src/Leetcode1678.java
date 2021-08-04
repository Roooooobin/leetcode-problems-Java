public class Leetcode1678 {

    class Solution {
        public String interpret(String command) {

            return command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al");
        }
    }
}
