class Solution {
    public boolean isPresent(String s,String str){
        for(int i=0;i<str.length();i++){
            if (s.contains(String.valueOf(str.charAt(i)))) return true;
        }
        return false;
    }
    public boolean isDuplicate(String s){
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a']>0) return true;
            arr[s.charAt(i)-'a']++;
        }
        return false;
    }
    public int solve(List<String> arr,int idx,String s,int len){
        if(idx<0) return len;
        if(isPresent(s,arr.get(idx)) || isDuplicate(arr.get(idx))){
            return solve(arr,idx-1,s,len);
        }
        else{
            int a=solve(arr,idx-1,s+arr.get(idx),len+arr.get(idx).length());
            int b=solve(arr,idx-1,s,len);
            return Math.max(a,b);
        }
    }
    public int maxLength(List<String> arr) {
        int n=arr.size();
        return solve(arr,n-1,"",0);
    }
}