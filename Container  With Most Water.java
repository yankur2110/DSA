class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int area = 0;
        
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                area = Math.min(height[i],height[j])*(j-i);
                max=Math.max(max,area);   
            }
        }
        return max;
    }
}