class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        long ans=0;
        int[] ng = new int[n]; // next greater
        int[] pg = new int[n]; // previous greater
        int[] ns = new int[n]; // next smaller
        int[] ps = new int[n]; // previous smaller
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                ng[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            ng[st.pop()]=n;
        }
        st.clear(); 


        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                pg[st.pop()] = i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            pg[st.pop()]=-1;
        }
        st.clear();


        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                ns[st.peek()]=i;
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            ns[st.peek()]=n;
            st.pop();
        }
        st.clear();


        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                ps[st.peek()]=i;
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            ps[st.peek()]=-1;
            st.pop();
        }
        for(int i=0;i<n;i++){
            ans+=(long)nums[i]*(i-pg[i])*(ng[i]-i);
            ans-=(long)nums[i]*(i-ps[i])*(ns[i]-i);
        }
        return ans;
    }
}