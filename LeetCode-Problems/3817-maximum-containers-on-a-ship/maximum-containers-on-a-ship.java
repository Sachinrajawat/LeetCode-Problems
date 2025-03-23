class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int x=maxWeight/w;
        return n*n<=x?n*n:x;
    }
}