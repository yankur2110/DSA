class Solution {
    public int maxTurbulenceSize(int[] arr) {
        char prevSign = '-', currSign = '-'; //sign is used to store prev sign.
        int maxSoFar = 0, maxTillNow = 0; //sliding window variables.

        //solve using sliding window concept.
        for(int i=1; i<arr.length ; i++){
            if(arr[i-1]>arr[i]){ //this if else, checks the current sign. i.e., sign of prevElement w.r.t currElement.
                currSign='>';
            }else if(arr[i-1]<arr[i]){
                currSign='<';
            }else{
                currSign='=';
            }

            if(prevSign==currSign || currSign=='='){    //if equal, change the window.
                maxSoFar=Math.max(maxSoFar, maxTillNow);
                maxTillNow = (currSign=='='?0:1);
            }else{  //if not equal, then continue to increment the same window... and accordingly maxSoFar.
                maxTillNow++;
                maxSoFar=Math.max(maxSoFar, maxTillNow);
            }

            prevSign=currSign; //assign currSign as the prevSign for next iteration.

        }

        return maxSoFar+1; //since maxSoFar stores the count of signs, number of elements would be 1 more than that.
    }
}
