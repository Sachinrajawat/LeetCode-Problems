class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int c=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<A.length;i++){
            if(set.contains(A[i])) c++;
            else set.add(A[i]);
            if(set.contains(B[i])) c++;
            else set.add(B[i]);
            A[i]=c;
        }
        return A;
    }
}