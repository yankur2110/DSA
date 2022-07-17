class Solution {
    public int minAddToMakeValid(String s) {
        int need_close_parenthesis=0,need_open_parenthesis=0;

        for(char ch : s.toCharArray()){
            if(ch=='('){
                //for any open parenthesis, we would definitely need a close parenthesis. Hence add need_close_parenthesis.
                need_close_parenthesis++;
            }else{ //in case of close parenthesis.
                //if we are already in need of close_parenthesis, then cancel out 1 close_parenthesis.
                if(need_close_parenthesis>0){
                    need_close_parenthesis--;
                }else{ //if not, it means it's an extra close_parenthesis, increment need_open_parenthesis.
                    need_open_parenthesis++;
                }
            }
        }

        //result would be addition of both.
        return need_close_parenthesis + need_open_parenthesis;
    }
}
