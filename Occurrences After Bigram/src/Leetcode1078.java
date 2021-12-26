import java.util.ArrayList;

public class Leetcode1078 {

    public String[] findOcurrences(String text, String first, String second) {

        String[] words = text.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < words.length - 2; i++) {

            if (words[i].equals(first) && words[i + 1].equals(second)) {
                res.add(words[i + 2]);
            }
        }
        return res.toArray(new String[0]);
    }
}
