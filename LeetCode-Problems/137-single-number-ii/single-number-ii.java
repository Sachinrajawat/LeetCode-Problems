class Solution {
    public int singleNumber(int[] nums) {
        int[] count=new int[32];
        for(int i=0;i<nums.length;i++){
            String s=Integer.toBinaryString(nums[i]);
            for(int j=0;j<s.length();j++){
                if(s.charAt(s.length()-1-j)=='1') count[31-j]++;
            }
        }
        String ans="";
        for(int i=0;i<32;i++){
            if(count[i]%3!=0) ans+='1';
            else ans+='0';
        }
        return (int)Long.parseLong(ans,2);
    }
}