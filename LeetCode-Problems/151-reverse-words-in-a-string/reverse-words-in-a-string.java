class Solution {
    public String reverseWords(String s) {
        int len=s.length();
        int i=0;
        ArrayList<String> arr=new ArrayList<>();
        while(i<len && s.charAt(i)==' ') i++;
        while(i<len){
            String str="";
            while(i<len && s.charAt(i)!=' '){
                str+=s.charAt(i);
                i++;
            }
            arr.add(str);
            while(i<len && s.charAt(i)==' ') i++;
        }
        String ans="";
        for(int j=arr.size()-1;j>=0;j--){
            ans+=arr.get(j);
            if(j!=0) ans+=" ";
        }
        return ans;
    }
}