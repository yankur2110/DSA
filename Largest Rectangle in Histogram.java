class Solution {
    
    //refer: https://www.youtube.com/watch?v=ZmnqCZp9bBs&t=600s&pbjreload=10
    /*main things:
        1. we keep on adding index to the stack till large bar are coming because area is increasing, but once we encounter small bar, we keep on popping till bar with equal or greater area is not found. If found we push it , because that can contribute to new aea.
    
    */

    
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0)
            return 0;
        
        Stack<Integer> barStack = new Stack<Integer>();
        int maxArea = Integer.MIN_VALUE;
        int top = 0;
        int i;
        
        
        for(i=0;i<heights.length;i++){
            
            if(barStack.isEmpty() || heights[i]>=heights[barStack.peek()]){
                barStack.push(i);
            }else{
                while(barStack.isEmpty()==false && heights[i]<heights[barStack.peek()]){ //keep popping till the top of stack value is > ith bar.
                    top=barStack.peek();
                    barStack.pop();
                    maxArea = Math.max(maxArea, calculateArea(top,barStack,heights,i));
                }
                barStack.push(i);
                
            }
        }
        
        while(barStack.isEmpty()==false){
        top=barStack.peek();
        barStack.pop();
        maxArea = Math.max(maxArea, calculateArea(top,barStack,heights,i));
        }
        
        return maxArea;

    }
    
    public int calculateArea( int top, Stack<Integer> stack, int[]heights, int i){
        if(stack.isEmpty()==true){
            //it means the the bar at index top is the smallest in the histogram till ith index.
            //also assuming there is no bar with 0 height.
            return heights[top]*(i);
        }else{
            int upperLimit = i-1;
            int lowerLimit = stack.peek();
            //area includes bar at upperLimit and excludes bar at lowerLimit...because it is sure that from (lowerLimit,UpperLimit] have height atleast heights[top].
            return heights[top]*(upperLimit-lowerLimit);
        }
    }
}