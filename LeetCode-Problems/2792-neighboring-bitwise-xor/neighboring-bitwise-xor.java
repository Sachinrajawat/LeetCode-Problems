class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n=derived.length;
        int a=0;
        for(int i=0;i<n-1;i++){
            a^=derived[i];
        }
        if((a^0)==derived[n-1]) return true;
        else{
            a=1;
            for(int i=0;i<n-1;i++){
            a^=derived[i];
            }
            
            if((a^1)==derived[n-1]) return true;
        }
        return false;
    }
}