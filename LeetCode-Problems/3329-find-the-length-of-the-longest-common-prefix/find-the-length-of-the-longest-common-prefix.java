class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set=new HashSet<>();
        int length=0;
        int n=arr1.length, m=arr2.length;
        for(int i=0;i<n;i++){
            while(arr1[i]!=0){
                if(set.contains(arr1[i])) break;
                set.add(arr1[i]);
                arr1[i]/=10;
            }
        }
        for(int i=0;i<m;i++){
            while(arr2[i]!=0){
                if(set.contains(arr2[i])){
                    String len=String.valueOf(arr2[i]);
                    length=Math.max(length, len.length());
                    break;
                }
                arr2[i]/=10;
            }
        }
        return length;
    }
}