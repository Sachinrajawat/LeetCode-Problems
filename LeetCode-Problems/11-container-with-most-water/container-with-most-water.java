class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int start=0,end=height.length-1;
        while(start<=end){
            int minHeight = Math.min(height[start], height[end]);
            int width = end - start;
            int area = minHeight * width;
            max = Math.max(max, area);
            
            if (height[start] < height[end]) start++;
            else end--;
        }
        return max;
    }
}