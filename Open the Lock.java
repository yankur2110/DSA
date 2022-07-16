class Solution {
    public int openLock(String[] deadends, String target) {
        //we will follow the bfs.
        Queue<String> que = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> deadlocks = new HashSet<>(Arrays.asList(deadends));
        que.add("0000");
        visited.add("0000");
        int level=0;

        while(!que.isEmpty()){
            int size=que.size();

            while(size-->0){
                String currDisplay = que.poll();
                if(deadlocks.contains(currDisplay)){
                    continue;
                }

                if(currDisplay.equals(target)) return level;

                StringBuilder sb = new StringBuilder(currDisplay);

                //for next lock, there are 2 possibilities at each wheel.
                //i.e., either +1 or -1. Also we need to handle the end cases i.e., 9 and 0 respectively.
                //if they are not visited or not deadlocks add to que.
                for(int i=0;i<4;i++){
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if(!visited.contains(s1) && !deadlocks.contains(s1)) {
                        que.offer(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2) && !deadlocks.contains(s2)) {
                        que.offer(s2);
                        visited.add(s2);
                    }
                }
            }
            level++;
        }

        return -1;
    }
}
