import java.util.*;

public class Jianzhi115 {

    // topology
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {

        int n  = org.length;
        HashSet<Integer> nums = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> adjacentMap = new HashMap<>();
        HashMap<Integer, Integer> inDegreeMap = new HashMap<>();
        // 构建邻接表，以及每个节点的入度，入度为0时表示应该加入
        for (List<Integer> seq : seqs) {
            nums.add(seq.get(0));
            for (int i = 0; i < seq.size() - 1; i++) {
                int x = seq.get(i), y = seq.get(i+1);
                adjacentMap.putIfAbsent(x, new ArrayList<>());
                adjacentMap.get(x).add(y);
                inDegreeMap.put(y, inDegreeMap.getOrDefault(y, 0) + 1);
                nums.add(y);
            }
        }
        // 节点个数不等于n，直接返回false
        if (nums.size() != n) {
            return false;
        }
        // 拓扑排序
        int[] res = new int[n];
        int idx = 0;
        Deque<Integer> q = new ArrayDeque<>();
        // 入度为0的加入序列
        for (Integer num : nums) {
            if (!inDegreeMap.containsKey(num)) {
                q.offerLast(num);
            }
        }
        while (!q.isEmpty()) {
            // 如果同时存在至少两个入度为0的节点，说明至少有两条分叉，不满足题意
            if (q.size() > 1) {
                return false;
            }
            int x = q.pollFirst();
            res[idx] = x;
            if (res[idx] != org[idx]) {
                return false;
            }
            idx++;
            for (int y : adjacentMap.getOrDefault(x, new ArrayList<>())) {
                int degree = inDegreeMap.get(y) - 1;
                if (degree == 0) {
                    q.offerLast(y);
                }
                inDegreeMap.put(y, degree);
            }
        }
        return idx == n;
    }
}
