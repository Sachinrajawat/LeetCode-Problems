class Solution {
    private static final int MOD = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            long sum=nums[i];
            arr.add((int) (sum % MOD));
            
            for(int j=i+1;j<nums.length;j++){
                sum=(sum + nums[j]) % MOD;;
                arr.add((int)sum);
            }
        }
        Collections.sort(arr);
        int ans=0;
        for(int i=left-1;i<right;i++){
            ans=(ans + arr.get(i)) % MOD;
        }
        return ans;
    }
}