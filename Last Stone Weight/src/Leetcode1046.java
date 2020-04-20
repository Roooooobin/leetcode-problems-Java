import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode1046 {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int stone: stones){
            pq.add(stone);
        }
        while(pq.size() >= 2){
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if(stone1 > stone2){
                pq.add(stone1 - stone2);
            }
        }
        return pq.isEmpty()? 0: pq.peek();
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}
