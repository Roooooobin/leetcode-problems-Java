import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1268 {
    public static int binarySearch(String[] products, String word) {
        int len = word.length();
        int l = 0, r = products.length - 1;
        while (l <= r) {
            int midIdx = l + (r - l) / 2;
            String midWhole = products[midIdx];
            String midSubString = midWhole.substring(0, Math.min(midWhole.length(), len));
            if (midSubString.compareTo(word) < 0) {
                l = midIdx + 1;
            }
            else {
                r = midIdx - 1;
            }
        }
        return l;
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        for (int i=1; i<=searchWord.length(); ++i) {
            String word = searchWord.substring(0, i);
            int lowerBound = binarySearch(products, word);
            List<String> res = new ArrayList<>();
            for (int j=lowerBound; j<Math.min(lowerBound+3, products.length); ++j) {
                if (products[j].substring(0, Math.min(products[j].length(), i)).equals(word)) {
                    res.add(products[j]);
                }
            }
            ans.add(res);
        }
        return ans;
    }

    public static void main(String[] args) {
         List<List<String>> ans = suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
         List<List<String>> ans2 = suggestedProducts(new String[]{"havana"}, "aaaaaa");
         System.out.println(ans);
         System.out.println(ans2);
//        System.out.println(binarySearch(new String[]{"mobile","mouse","moneypot","monitor","mousepad","solve","moose","moon","morning","monan"}, "a"));
    }
}
