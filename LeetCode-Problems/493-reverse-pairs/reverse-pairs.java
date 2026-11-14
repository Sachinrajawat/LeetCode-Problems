class Solution {
    public int count=0;
    public void merge(int[] nums,int low,int mid,int high){
        int[] arr=new int[high-low+1];
        int left=low, right=mid+1;
        int i=0;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                arr[i++]=nums[left];
                left++;
            }else{
                arr[i++]=nums[right];
                right++;
            }
        }
        while(left<=mid){
            arr[i++]=nums[left];
            left++;
        }
        while(right<=high){
            arr[i++]=nums[right];
            right++;
        }
        for(int j=low;j<=high;j++){
            nums[j]=arr[j-low];
        }
    }

    void countPairs(int[] nums, int low, int mid, int high){
        int left=low, right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && nums[i]>2L*nums[right]) right++;
            count+=(right-(mid+1));
        }
    }
    public void mergeSort(int[] nums,int low, int high){
        if(low>=high) return;
        int mid=low+(high-low)/2;
        mergeSort(nums,low, mid);
        mergeSort(nums,mid+1, high);
        countPairs(nums, low, mid,high);
        merge(nums, low, mid, high);
    }
    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return count;
    }
}