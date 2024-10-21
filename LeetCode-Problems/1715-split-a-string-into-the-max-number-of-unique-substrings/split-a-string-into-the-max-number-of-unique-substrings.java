class Solution {
    public int max=0;
    public void solve(List<String> arr,String s,int start){
        if(start==s.length()){
            max=Math.max(max,arr.size());
            return;
        }
        for(int end=start+1;end<=s.length();end++){
            String str=s.substring(start,end);
            if(!arr.contains(str)){
                arr.add(str);
                solve(arr,s,end);
                arr.remove(arr.size()-1);
            }
        }
    }
    public int maxUniqueSplit(String s) {
        List<String> arr=new ArrayList<>();
        solve(arr,s,0);
        return max;
    }
}