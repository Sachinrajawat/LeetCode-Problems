import java.util.*;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (var key : map.keySet()) {
            pq.add(new int[]{key - 'a', map.get(key)});
        }

        StringBuilder str = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            char currChar = (char) (curr[0] + 'a');
            int appendCount = Math.min(repeatLimit, curr[1]);

            for (int i = 0; i < appendCount; i++) {
                str.append(currChar);
            }

            curr[1] -= appendCount;

            if (curr[1] > 0) {
                if (pq.isEmpty()) {
                    break;
                }

                int[] next = pq.poll();
                char nextChar = (char) (next[0] + 'a');
                str.append(nextChar);
                next[1]--;
                if (next[1] > 0) {
                    pq.add(next);
                }

                pq.add(curr);
            }
        }

        return str.toString();
    }
}
