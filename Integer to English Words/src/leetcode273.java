public class leetcode273 {

    // https://leetcode.com/problems/integer-to-english-words/discuss/70625/My-clean-Java-solution-very-easy-to-understand
    private final String[] LESS_THAN_20 = {
        "",
        "One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen",
        "Fifteen",
        "Sixteen",
        "Seventeen",
        "Eighteen",
        "Nineteen"
    };
    private final String[] TENS = {
        "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            if (num % 1000 != 0) {
                res.insert(0, helper(num % 1000) + THOUSANDS[i] + " ");
            }
            num /= 1000;
            i++;
        }
        return res.toString().trim();
    }

    private String helper(int num) {

        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
