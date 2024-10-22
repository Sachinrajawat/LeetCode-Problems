class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int i = 0; i < profits.length; i++) {
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }
    
        while (k > 0) {
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll()[1]);
            }
            
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            w += maxProfitHeap.poll();
            k--;
        }
        
        return w;
    }
}