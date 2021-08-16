public class Leetcode434 {

    public int countSegments(String s) {

        int res = 0;
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < arr.length && arr[i] == ' ') {
            i++;
        }
        while (i < arr.length) {
            while (i < arr.length && arr[i] != ' ') {
                i++;
            }
            res++;
            while (i < arr.length && arr[i] == ' ') {
                i++;
            }
        }
        return res;
    }
}
