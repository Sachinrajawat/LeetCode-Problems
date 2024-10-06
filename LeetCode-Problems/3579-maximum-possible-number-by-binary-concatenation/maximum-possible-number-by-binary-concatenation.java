class Solution {
    public int maxGoodNumber(int[] nums) {
        String f=Integer.toBinaryString(nums[0]);
        String s=Integer.toBinaryString(nums[1]);
        String t=Integer.toBinaryString(nums[2]);
        String ans=f+s+t;
        int result=Integer.parseInt(ans,2);
        ans=f+t+s;
        result=Math.max(result,Integer.parseInt(ans,2));
        ans=t+s+f;
        result=Math.max(result,Integer.parseInt(ans,2));
        ans=t+f+s;
        result=Math.max(result,Integer.parseInt(ans,2));
        ans=s+f+t;
        result=Math.max(result,Integer.parseInt(ans,2));
        ans=s+t+f;
        result=Math.max(result,Integer.parseInt(ans,2));

        return result;
    }
}