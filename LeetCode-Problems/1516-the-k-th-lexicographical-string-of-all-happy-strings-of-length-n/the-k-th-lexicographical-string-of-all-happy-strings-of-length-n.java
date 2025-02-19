class Solution {
    public void solve(ArrayList<String> arr,int n,int idx,char[] ch,StringBuilder s){
        if(idx==n){
            arr.add(s.toString());
            return;
        }
        for(int i=0;i<3;i++){
            if (s.length() == 0 || s.charAt(s.length() - 1) != ch[i]){
                s.append(ch[i]);
                solve(arr,n,idx+1,ch,s);
                s.deleteCharAt(s.length() - 1);
            }
        }
    } 
    public String getHappyString(int n, int k) {
        ArrayList<String> arr=new ArrayList<>();
        char[] ch={'a','b','c'};
            solve(arr,n,0,ch,new StringBuilder());
            
         if (k > arr.size()) return "";
        return arr.get(k-1);
    }
}