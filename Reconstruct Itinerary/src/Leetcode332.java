import java.util.*;

public class Leetcode332 {

    // WA
    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort(Comparator.comparing(o -> o.get(0)));
        Map<String, LinkedList<String>> hash = new HashMap<>();
        for (List<String> list : tickets) {
            String from = list.get(0);
            if (!hash.containsKey(from)) {
                hash.put(from, new LinkedList<>());
            }
            hash.get(from).offer(list.get(1));
        }
        LinkedList<String> ans = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.offerLast("JFK");
        while (!stack.isEmpty()) {
            while (hash.containsKey(stack.peek()) && !hash.get(stack.peek()).isEmpty()) {
                stack.push(hash.get(stack.peek()).pollFirst());
            }
            ans.offerFirst(stack.pollLast());
        }
        Collections.reverse(ans);
        return ans;
    }

    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (String[] ticket : tickets)
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        List<String> route = new LinkedList();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }

    public static void main(String[] args) {
        Leetcode332 leetcode332 = new Leetcode332();
        List<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList("SFO","ATL"));
        lists.add(Arrays.asList("JFK","ATL"));
        lists.add(Arrays.asList("ATL","JFK"));
        lists.add(Arrays.asList("ATL","SFO"));
        lists.add(Arrays.asList("JFK","SFO"));
        leetcode332.findItinerary(lists);
    }
}
