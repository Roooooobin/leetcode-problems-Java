public class Leetcode38 {
    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String prev = countAndSay(n-1);
        StringBuilder cur = new StringBuilder();
        char ch = prev.charAt(0);
        int i = 1;
        int count = 1;
        while (i != prev.length()) {
            if (ch == prev.charAt(i)) {
                count++;
            } else {
                cur.append(count).append(ch);
                ch = prev.charAt(i);
                count = 1;
            }
            ++i;
        }
        cur.append(count).append(ch);
        return cur.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(10));
    }
}
