class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] resultArray = new int[temperatures.length];
        Stack<Integer> monotonousStack = new Stack<>(); //here in stack we are storing index and not the values.

        for(int i=0;i<temperatures.length;i++){
            while(!monotonousStack.isEmpty() && temperatures[monotonousStack.peek()]<temperatures[i]){
                int indexPopped = monotonousStack.pop();
                resultArray[indexPopped] = i-indexPopped;
            }
          monotonousStack.push(i);
        }

        return resultArray;
    }
}
