class Solution {
    public int minBitFlips(int start, int goal) {
        int xor=start^goal;
        int count=Integer.bitCount(xor);
        return count;
    }
}