class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            while(arr1[i]!=0){
                // if(set.contains(arr1[i])) break;
                set.add(arr1[i]);
                arr1[i]/=10;
            }
        }
        int max=0;
        for(int i=0;i<arr2.length;i++){
            while(arr2[i]!=0){
                if(set.contains(arr2[i])){
                    String s=String.valueOf(arr2[i]);
                    max=Math.max(max,s.length());
                    break;
                }
                arr2[i]/=10;
            }
        }
        System.out.println(set);
        return max;
    }
}