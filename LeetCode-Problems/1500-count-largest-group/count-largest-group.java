class Solution {
    public int sum(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public int countLargestGroup(int n) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<=n;i++){
            int s=sum(i);
            map.put(s,map.getOrDefault(s,0)+1);
        }
        Map<Integer,Integer> map1=new HashMap<>();
        int max=0;
        for(var key:map.keySet()){
            map1.put(map.get(key),map1.getOrDefault(map.get(key),0)+1);
            max=Math.max(max,map.get(key));
        }
        return map1.get(max);
    }
}