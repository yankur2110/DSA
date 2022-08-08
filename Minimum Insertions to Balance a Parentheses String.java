class Solution {
    public int minInsertions(String s) {
        s=s.replace("))","]");
        int left=0;
        int count=0;

        for(char ch : s.toCharArray()){
            if(ch=='('){
                left++;
            }else if((ch==')' || ch==']') && left>0){
                count+= (ch==']')?0:1;
                left--;
            }else{
                count+= (ch==')')?2:1;
            }
        }

        return count + left * 2;
    }
}
