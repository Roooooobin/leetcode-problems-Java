import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Leetcode791 {

    public String customSortString(String order, String str) {

        HashMap<Character, Integer> char2IdxMap = new HashMap<>();
        for (int i = 0; i < order.length(); ++i) {
            char2IdxMap.put(order.charAt(i), i);
        }
        char[] chars = str.toCharArray();
        Character[] charArrStr = new Character[chars.length];
        for (int i = 0; i < chars.length; i++) {
            charArrStr[i] = chars[i];
        }
        Arrays.sort(charArrStr, Comparator.comparingInt(o -> char2IdxMap.getOrDefault(o, 0)));
        StringBuilder sb = new StringBuilder();
        for (Character character : charArrStr) {
            sb.append(character);
        }
        return sb.toString();
    }
}
