class Solution {
    public String getHappyString(int n, int k) {
        Queue<String> que = new LinkedList<>();
        que.add("a");
        que.add("b");
        que.add("c");
        int currentLevel=1;


        while(currentLevel!=n){
            currentLevel++;
            int size=que.size();

            for(int i=0;i<size;i++){
                String polledStr = que.poll();
                int lastChar = polledStr.charAt(polledStr.length()-1);

                for(char ch='a'; ch<='c';ch++){
                    if(lastChar!=ch){
                        que.add(polledStr+Character.toString(ch));
                    }
                }
            }
        }

        String result = "";
        if(que.size()<k) return result;
        else{
            String temp="";
            while((k-1)>0){
                que.poll();
                k--;
            }
        }


        return que.poll();
    }
}
