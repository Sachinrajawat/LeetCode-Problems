class Solution {
    public String ans="";
    public void solve(HashSet<String> arr,String[] s,String str){
        if(str.length()>=arr.size()) return;
        for(int i=0;i<2;i++){
            str+=s[i];
            if(str.length()==arr.size() && (!arr.contains(str))){
                ans=str;
                break;
            }
            solve(arr,s,str);
            str=str.substring(0,str.length()-1);
        }
        return;
    }
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> arr=new HashSet<>(Arrays.asList(nums));
        for(String num:nums) arr.add(num);
        String[] s={"0","1"};
        solve(arr,s,"");
        return ans;
    }
}