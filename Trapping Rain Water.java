class Solution {
    
    /* video_ref: https://www.youtube.com/watch?v=HmBbcDiJapY
    we are checking what unit of water can be stored on the top of each bar, and then adding them all.
    */
    
    public int trap(int[] height) {
        if(height.length<2){
            return 0;
        }
        
        int area = 0;
        HashMap<Integer,Integer> hashMap_left_max = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> hashMap_right_max = new HashMap<Integer,Integer>();
        hashMap_left_max.put(0,0);
        hashMap_right_max.put(height.length-1,0);
        
        for(int i=1;i<height.length;i++){
            hashMap_left_max.put(i,Math.max(hashMap_left_max.get(i-1),height[i-1]));
        }
        
        for(int i=height.length-2; i>=0;i--){
            hashMap_right_max.put(i,Math.max(hashMap_right_max.get(i+1),height[i+1]));
        }
        
         for(int i=0;i<height.length;i++){
           int each_bar_unit=Math.min(hashMap_left_max.get(i),hashMap_right_max.get(i))-height[i];
             if(each_bar_unit>0){
                 area=each_bar_unit+area;
             }
         }
        
        return area;
    }
        
}