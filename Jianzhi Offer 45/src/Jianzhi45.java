import java.util.Arrays;

public class Jianzhi45 {

    public String minNumber(int[] nums) {

        int n = nums.length;
        String[] strings = new String[n];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(
                strings,
                (o1, o2) -> {
                    String o3 = o1 + o2, o4 = o2 + o1;
                    return o3.compareTo(o4);
                });
        StringBuilder res = new StringBuilder();
        for (String string : strings) {
            res.append(string);
        }
        return res.toString();
    }
}
