class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k%=nums.length;
        int[] arr=new int[k];
        int j=k;
        for(int i=n-1;i>n-k-1;i--){
            arr[j-1]=nums[i];
            j--;
        }
        for(int i=n-k-1;i>=0;i--){
            nums[i+k]=nums[i];
        }
        for(int i=0;i<k;i++){
            nums[i]=arr[i];
        }
    }
}