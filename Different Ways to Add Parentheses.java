class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> resultList = new ArrayList<>();

        for(int i=0;i<expression.length();i++){

            //if there are characters present in the string, we will try to break it in every possible way i.e., indirectly placing brackets on left and right expression.
            if(expression.charAt(i)=='+' || expression.charAt(i)=='-' ||expression.charAt(i)=='*' ){
                String leftString = expression.substring(0,i);
                String rightString = expression.substring(i+1,expression.length());

                List<Integer> leftPossibleNumbers = diffWaysToCompute(leftString);
                List<Integer> rightPossibleNumbers = diffWaysToCompute(rightString);


                for(int leftPossibleNumber : leftPossibleNumbers){
                    for(int rightPossibleNumber : rightPossibleNumbers){
                        int num=0;
                        switch(expression.charAt(i)){
                                case '+' : num=leftPossibleNumber+rightPossibleNumber;
                                break;

                                case '-' : num=leftPossibleNumber-rightPossibleNumber;
                                break;

                                case '*' : num=leftPossibleNumber*rightPossibleNumber;
                                break;

                        }
                        resultList.add(num);
                    }
                }

            }
        }

        //case where there were no sign character present in the string.
        if(resultList.size()==0){
            resultList.add(Integer.valueOf(expression));
        }

        return resultList;
    }
}
