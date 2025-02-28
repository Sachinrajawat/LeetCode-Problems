class Solution {
    public int solve1(int j,int k, int[] arr, HashMap<Integer, Integer> map){
        int target=arr[k]-arr[j];
        if(map.containsKey(target) && map.get(target)<j){
            int i=map.get(target);
            return solve1(i,j,arr,map)+1;
        }
        return 2;
    }
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int res=0;
        for(int j=1;j<arr.length-1;j++){
            for(int k=j+1;k<arr.length;k++){
                int len=solve1(j,k,arr,map);
                if(len>=3){
                    res=Math.max(res,len);
                }
            }
        }
        return res;
    }
}