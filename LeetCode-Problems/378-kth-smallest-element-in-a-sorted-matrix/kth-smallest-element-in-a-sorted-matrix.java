class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for (int r=0;r<n;r++) {
            for (int c=0;c<n;c++) {
                maxHeap.offer(matrix[r][c]);
                if (maxHeap.size()>k) maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }
}