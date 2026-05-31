class Solution {
    public int digitFrequencyScore(int n) {
        Map<Integer, Integer> map=new HashMap<>();
        while(n>0){
            int x=n%10;
            map.put(x,map.getOrDefault(x,0)+1);
            n/=10;
        }
        int sum=0;
        for(var val:map.keySet()){
            sum+=val*map.get(val);
        }
        return sum;
    }
}