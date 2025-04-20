class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<answers.length;i++){
            map.put(answers[i]+1,map.getOrDefault(answers[i]+1,0)+1);
        }
        
        for(var key:map.keySet()){
            int a=map.get(key), b=key;
            int result=(int)Math.ceil((double)a/b);
            ans+=key*result;
        }
        return ans;
    }
}