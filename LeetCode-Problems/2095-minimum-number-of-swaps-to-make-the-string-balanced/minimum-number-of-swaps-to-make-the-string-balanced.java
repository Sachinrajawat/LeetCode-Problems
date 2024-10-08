class Solution {
    public int minSwaps(String s) {
        int unbalanced=0;

        for (char c:s.toCharArray()) {
            if (c=='[') {
                unbalanced++;
            }
            else if(unbalanced>0) {
                unbalanced--;
            }
        }
        return (unbalanced+1)/2;
    }
}