import java.util.*;

class topKFrequent {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(topKFrequent(new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    static List<String> topKFrequent(String[] words, int k){
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String s: words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue() == b.getValue()
                        ? b.getKey().compareTo(a.getKey())
                        : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry: map.entrySet()){
            pq.offer(entry);
            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty()){
            result.add(0, pq.poll().getKey());
        }

        return result;
    }


}