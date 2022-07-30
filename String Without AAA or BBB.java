class Solution {
    public String strWithout3a3b(int a, int b) {
        int countA=0;
        int countB=0;
        int continuousA=0, continuousB=0;
        StringBuilder result = new StringBuilder();

        while(countA<a || countB<b){
            int leftA=a-countA;
            int leftB=b-countB;

            boolean keepFirstTogether = (leftA>leftB)?true:false; //in each turn check which has more count.

            if(keepFirstTogether){ //case where 'a' occurs more number of time. So,we will want to keep maximum number of 'a's together since b's are less.
                if(continuousA<2){ //check if already "aa" is present.
                    result.append("a");
                    continuousA++;
                    continuousB=0;
                    countA++;
                }else{
                    result.append("b");
                    continuousB++;
                    countB++;
                    continuousA=0;
                }
            }else{ //case where 'b' occurs more number of time. So, we will want to keep maximum number of 'b's together since a's a re less.
                if(continuousB<2){ //check if already "bb" is present.
                    result.append("b");
                    continuousB++;
                    continuousA=0;
                    countB++;
                }else{
                    result.append("a");
                    continuousA++;
                    countA++;
                    continuousB=0;
                }
            }
        }

        return result.toString();
    }
}
