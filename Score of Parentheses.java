class Solution {
    public int scoreOfParentheses(String s) {
        //I DIDN'T UNDERSTAND IT PROPERLY.
        int score =0;
        Stack<Integer> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch=='('){
                stack.push(score); //score generated till now. For e.g., (()()).. suppose we are index 3.. so we will push the previous score.
                score=0;
            }else{
                score=stack.pop() + Math.max(score*2,1); //very logical/found it hard to understand..
            }
        }

        return score;

    }
}
