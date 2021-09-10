import java.util.HashMap;

public class Leetcode1640 {

    public boolean canFormArray(int[] arr, int[][] pieces) {

        HashMap<Integer, Integer> idxMapOfPieces = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            idxMapOfPieces.put(pieces[i][0], i);
        }
        int i = 0;
        while (i < arr.length) {
            int idx = idxMapOfPieces.getOrDefault(arr[i], -1);
            if (idx == -1) {
                return false;
            }
            i++;
            for (int j = 1; j < pieces[idx].length; j++) {
                if (arr[i] != pieces[idx][j]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}
