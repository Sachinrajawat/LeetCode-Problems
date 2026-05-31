class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int max=0;
        for(int asteroid: asteroids){
            max=Math.max(max,asteroid);
            pq.add(asteroid);
        }
        while(pq.size()!=0){
            int x=pq.remove();
            if(mass<x) return false;
            else mass+=x; 
            if(max<mass) return true;
        }
        return true;
    }
}