import java.util.HashSet;
import java.util.List;

public class Leetcode1436 {

    public String destCity(List<List<String>> paths) {

        HashSet<String> cities = new HashSet<>();
        HashSet<String> in = new HashSet<>();
        for (List<String> path : paths) {
            cities.add(path.get(0));
            cities.add(path.get(1));
            in.add(path.get(0));
        }
        for (String city : cities) {
            if (!in.contains(city)) {
                return city;
            }
        }
        return "";
    }
}
