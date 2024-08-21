class Solution {
    public int[] resultsArray(int[] nums, int k) {
        
        int n=nums.length;
        /*int[] preSum=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            preSum[i]=sum;
            System.out.println(sum);
        }
        int[] result=new int[n-k+1];
        int j=1;
        if(preSum[k-1]-nums[0]*k==(k-1)*(k)/2) result[0]=nums[k-1];
        else result[0]=-1;
        for(int i=k;i<n;i++){
            int x=preSum[i]-preSum[i-k]-nums[i-k+1]*k;
            if(x==(k-1)*(k)/2){
                if(nums[i]<nums[i-1] && k!=1) result[j]=-1;
                else result[j]=nums[i];
            }
            else result[j]=-1;
            j++;
        }
        return result;*/
        if (k == 1) return nums;
        
        int[] arr = new int[n];
        
        // Populate arr array
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                arr[i] = 1;
            }
        }
        
        int c = 0;
        
        // Count initial k elements
        for (int i = 0; i < k; i++) {
            if (arr[i] == 1) c++;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        // First window result
        if (c == 0) ans.add(nums[k - 1]);
        else ans.add(-1);
        
        // Sliding window
        for (int i = k; i < n; i++) {
            if (arr[i] == 1) c++;
            if (arr[i - k+1] == 1) c--;
            if (c == 0) ans.add(nums[i]);
            else ans.add(-1);
        }
        
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        
        return result;
    }
}