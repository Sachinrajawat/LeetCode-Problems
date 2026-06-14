class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge=new int[nums2.length];
        Arrays.fill(nge,-1);
        for(int i=0;i<nums2.length-1;i++){
            for(int j=i;j<nums2.length;j++){
                if(nums2[i]<nums2[j]){
                    nge[i]=nums2[j];
                    break;
                }
            }
            // System.out.println(nge[i]);
        }
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    // System.out.print(j+"   "+nge[j]+" ");
                    ans[i]=nge[j];
                }
            }
        }
        return ans;
    }
}