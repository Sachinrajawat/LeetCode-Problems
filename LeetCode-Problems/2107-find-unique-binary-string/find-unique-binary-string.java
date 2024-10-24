class Solution {
    public void solve(ArrayList<String> arr,String[] s,String str,ArrayList<String> ans){
        if(str.length()>=arr.size()) return;
        int j=0;
        for(int i=0;i<2;i++){
            str+=s[i];
            if(str.length()==arr.size() && (!arr.contains(str))) ans.add(str);
            solve(arr,s,str,ans);
            str=str.substring(0,str.length()-1);
        }
        return;
    }
    public String findDifferentBinaryString(String[] nums) {
        ArrayList<String> arr=new ArrayList<>();
        for(String num:nums) arr.add(num);
        String[] s={"0","1"};
        ArrayList<String> ans=new ArrayList<>();
        solve(arr,s,"",ans);
        // System.out.println(ans);
        return ans.get(0);
    }
}