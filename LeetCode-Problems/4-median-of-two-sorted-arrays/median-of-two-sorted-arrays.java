class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans=0;
        int m=nums1.length;
        int n=nums2.length;
        int[] arr=new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(nums1[i]>nums2[j]) arr[k++]=nums2[j++];
            else if(nums1[i]<nums2[j]) arr[k++]=nums1[i++];
            else{
                arr[k++]=nums1[i++];
                arr[k++]=nums2[j++];
            }
        }
        while(i<m) arr[k++]=nums1[i++];

        while(j<n) arr[k++]=nums2[j++];

        if(arr.length%2!=0) ans=arr[arr.length/2];
        else ans=(arr[(arr.length/2)-1]+arr[arr.length/2])/2.0;

        return ans;
    }
}