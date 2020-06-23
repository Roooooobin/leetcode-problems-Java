import java.util.*;

public class Leetcode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> hash = new HashSet<>();
        Set<String> ans = new HashSet<>();
        for (int i=0; i<s.length()-9; ++i) {
            String dna = s.substring(i, i+10);
            if (hash.contains(dna)) {
                ans.add(dna);
            }
            else hash.add(dna);
        }
        return new ArrayList<>(ans);
    }
}
