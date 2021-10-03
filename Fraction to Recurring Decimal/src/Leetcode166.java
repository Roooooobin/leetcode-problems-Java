import java.util.HashMap;

public class Leetcode166 {

    public String fractionToDecimal(int numerator, int denominator) {

        long a = (long) numerator, b = (long) denominator;
        if (a % b == 0) {
            return String.valueOf(a / b);
        }

        StringBuilder res = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            res.append('-');
        }
        // Integer part
        a = Math.abs(a);
        b = Math.abs(b);
        long integerPart = a / b;
        res.append(integerPart);
        res.append('.');
        // decimal
        StringBuilder fractionPart = new StringBuilder();
        HashMap<Long, Integer> reminderIndexMap = new HashMap<>();
        long remainder = a % b;
        int idx = 0;
        while (remainder != 0 && !reminderIndexMap.containsKey(remainder)) {
            reminderIndexMap.put(remainder, idx++);
            remainder *= 10;
            fractionPart.append(remainder / b);
            remainder %= b;
        }
        // has circle
        if (remainder != 0) {
            int insertIdx = reminderIndexMap.get(remainder);
            fractionPart.insert(insertIdx, '(');
            fractionPart.append(')');
        }
        res.append(fractionPart.toString());
        return res.toString();
    }
}
