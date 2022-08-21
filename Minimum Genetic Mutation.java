class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int minMutation=0;

        boolean[] visited = new boolean[bank.length];
        Queue<String> que = new LinkedList<>();
        que.add(start);

        while(!que.isEmpty()){
            int size = que.size();

            for(int i=0;i<size;i++){
                String newStart = que.poll();
                if(newStart.equals(end)) return minMutation;

                for(int j=0;j<bank.length;j++){
                    if(!visited[j] && isValidMove(newStart, bank[j])){
                        que.add(bank[j]);
                        visited[j]=true;
                    }
                }

            }
            minMutation++;
        }
        return -1;
    }

    public boolean isValidMove(String start, String end){
        int count=0;

        for(int i=0;i<8;i++){
            if(start.charAt(i)!=end.charAt(i)){
                count++;
            }
        }
        return count==1;
    }
}
