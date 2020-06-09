import java.util.*;

public class TopKFrequentlyMentionedKeywords {
    private static List<String> getTopKFrequent(int k, String[] keywords, String[] reviews) {
        Map<String, Integer> count = new HashMap<>();
        for (String review : reviews) {
            // 因为一个review中可能出现多个单词，但是计算频率时只能算一次
            Set<String> curWords = new HashSet<>(Arrays.asList(review.toLowerCase().split("\\W")));
            for (String word : keywords) {
                if (curWords.contains(word)) {
                    count.merge(word, 1, Integer::sum);
                }
            }
        }
        System.out.println(count);
        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ?
                a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        maxHeap.addAll(count.entrySet());
        List<String> ans = new ArrayList<>();
        while (!maxHeap.isEmpty() && k-- > 0) {
            ans.add(maxHeap.poll().getKey());
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] keywords = {"anacell", "cetracular", "betacellular"};
        String[] reviews = {"Anacell provides the best services in the city",
                "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell",};
        List<String> res = getTopKFrequent(2, keywords, reviews);
        String[] keywords2 = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews2 = {"I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular."};
        List<String> res2 = getTopKFrequent(3, keywords2, reviews2);
        System.out.println(res);
        System.out.println(res2);
    }
}
