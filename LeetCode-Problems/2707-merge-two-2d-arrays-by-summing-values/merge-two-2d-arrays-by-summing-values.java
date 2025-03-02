class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int i=0,j=0,k=0;
        int[][] ans = new int[nums1.length + nums2.length][2];
        while(i<nums1.length && j<nums2.length){
            if(nums1[i][0]==nums2[j][0]){
                ans[k][0]=nums1[i][0];
                ans[k][1]=nums1[i][1]+nums2[j][1];
                i++;
                j++;
                k++;
            }
            else if(nums1[i][0]>nums2[j][0]){
                ans[k][0]=nums2[j][0];
                ans[k][1]=nums2[j][1];
                k++;
                j++;
            }
            else{
                ans[k][0]=nums1[i][0];
                ans[k][1]=nums1[i][1];
                k++;
                i++;
            }
        }
        while(i<nums1.length){
            ans[k][0]=nums1[i][0];
            ans[k][1]=nums1[i][1];
            k++;
            i++;
        }
        while(j<nums2.length){
            ans[k][0]=nums2[j][0];
            ans[k][1]=nums2[j][1];
            k++;
            j++;
        }
        return java.util.Arrays.copyOf(ans, k);
    }
}