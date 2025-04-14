class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] nge=new int[n];
        Stack<Integer> st1=new Stack<>();
        // nums = [1,2,1] -> [1,2,1,1,2] 
        for(int i=2*n-1;i>=0;i--){
            int idx=i%n;
            while(!st1.isEmpty() && st1.peek()<=nums[idx]){
                st1.pop();
            }
            nge[idx]=st1.isEmpty()?-1:st1.peek();
            
            st1.push(nums[idx]);
        }
        return nge;
    }
}