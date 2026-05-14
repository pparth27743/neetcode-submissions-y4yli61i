class Solution {
    public int maxArea(int[] heights) {

        int i=0;
        int j=heights.length - 1;
        int maxWater = 0;
        while(i<j) {
            maxWater = Math.max(maxWater, Math.min(heights[i], heights[j])*(j-i));
            if(heights[i]<heights[j])
                i++;
            else 
                j--;
        }
        return maxWater;
    }
}
