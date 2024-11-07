class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitCount=new int[24];
        for(int i=0;i<candidates.length;i++){
            String bin=Integer.toBinaryString(candidates[i]);
            // System.out.println(bin);
            int k=23;
            for(int j=bin.length()-1;j>=0;j--){
                if(bin.charAt(j)=='1') bitCount[k]++;
                k--;
            }
        }
        int max=0;
        for(int i=0;i<24;i++){
            max=Math.max(max,bitCount[i]);
        }
        // for(int c:bitCount) System.out.println(c);
        return max;
    }
}