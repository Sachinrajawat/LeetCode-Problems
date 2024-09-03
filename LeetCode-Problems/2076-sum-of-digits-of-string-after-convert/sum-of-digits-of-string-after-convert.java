class Solution {
    public int getLucky(String s, int k) {
        String str="";
        for(int i=0;i<s.length();i++) str+=String.valueOf(s.charAt(i)-'a'+1);

        while(k>0){
            int sum=0;
            for(int i=0;i<str.length();i++) sum+=Integer.parseInt(String.valueOf(str.charAt(i)));
            str=String.valueOf(sum);
            k--;
        }
        return Integer.parseInt(str);
    }
}