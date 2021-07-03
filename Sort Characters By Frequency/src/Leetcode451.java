import java.util.Arrays;

public class Leetcode451 {
    public static String frequencySort(String s) {

        int[] char2CountMap = new int[255];
        Character[] characters = new Character[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            char2CountMap[c]++;
            characters[i] = c;
        }
        Arrays.sort(
                characters,
                (o1, o2) -> {
                    if (char2CountMap[o2] == char2CountMap[o1]) {
                        return o2 - o1;
                    } else {
                        return char2CountMap[o2] - char2CountMap[o1];
                    }
                });
        StringBuilder sb = new StringBuilder();
        for (Character c : characters) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("asfhaofhasociohaAAAz"));
    }
}
