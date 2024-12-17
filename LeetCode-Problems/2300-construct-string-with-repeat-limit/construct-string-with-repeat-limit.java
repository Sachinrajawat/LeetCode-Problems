import java.util.*;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // Count frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Priority queue to store characters in descending order
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (var key : map.keySet()) {
            pq.add(new int[]{key - 'a', map.get(key)});
        }

        StringBuilder str = new StringBuilder();

        while (!pq.isEmpty()) {
            // Poll the most frequent character
            int[] curr = pq.poll();
            char currChar = (char) (curr[0] + 'a');
            int appendCount = Math.min(repeatLimit, curr[1]);

            // Append up to `repeatLimit` times
            for (int i = 0; i < appendCount; i++) {
                str.append(currChar);
            }

            // Decrease frequency of the current character
            curr[1] -= appendCount;

            // Handle the case where another character is needed
            if (curr[1] > 0) {
                if (pq.isEmpty()) {
                    // If no other character is available, stop (to prevent consecutive repeats)
                    break;
                }

                // Use the next most frequent character
                int[] next = pq.poll();
                char nextChar = (char) (next[0] + 'a');
                str.append(nextChar);

                // Decrease its frequency and re-add it if still usable
                next[1]--;
                if (next[1] > 0) {
                    pq.add(next);
                }

                // Re-add the current character to the queue
                pq.add(curr);
            }
        }

        return str.toString();
    }
}
