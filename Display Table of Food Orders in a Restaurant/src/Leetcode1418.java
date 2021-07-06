import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Leetcode1418 {

    public List<List<String>> displayTable(List<List<String>> orders) {

        List<List<String>> res = new ArrayList<>();
        TreeSet<String> foodNames = new TreeSet<>();
        List<String> title = new ArrayList<>();
        title.add("Table");

        TreeMap<Integer, TreeMap<String, Integer>> table2Food2CountMap = new TreeMap<>();
        for (List<String> order : orders) {
            Integer tableNoInt = Integer.valueOf(order.get(1));
            TreeMap<String, Integer> food2CountMap =
                    table2Food2CountMap.getOrDefault(tableNoInt, new TreeMap<>());
            String foodName = order.get(2);
            foodNames.add(foodName);
            food2CountMap.put(foodName, food2CountMap.getOrDefault(foodName, 0) + 1);
            table2Food2CountMap.put(tableNoInt, food2CountMap);
        }

        title.addAll(foodNames);
        res.add(title);

        for (Integer tableNo : table2Food2CountMap.keySet()) {

            TreeMap<String, Integer> food2CountMap = table2Food2CountMap.get(tableNo);
            List<String> line = new ArrayList<>();
            line.add(String.valueOf(tableNo));
            for (String foodName : foodNames) {
                line.add(Integer.toString(food2CountMap.getOrDefault(foodName, 0)));
            }
            res.add(line);
        }

        return res;
    }
}
