import java.util.TreeMap;

public class Leetcode1146 {

    class SnapshotArray {

        TreeMap<Integer, Integer>[] snapShots;
        int snapID = 0;

        public SnapshotArray(int length) {

            snapShots = new TreeMap[length];
            for (int i = 0; i < length; i++) {
                snapShots[i] = new TreeMap<>();
                snapShots[i].put(0, 0);
            }
        }

        public void set(int index, int val) {
            snapShots[index].put(snapID, val);
        }

        public int snap() {
            return snapID++;
        }

        public int get(int index, int snap_id) {

            return snapShots[index].floorEntry(snap_id).getValue();
        }
    }
}
