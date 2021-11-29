class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        if(cells==null || cells.length==0 || n<=0) return cells;
        
        Set<String> hashSet = new HashSet<>();
        boolean hasCycle = false;
        int size=0;
        
        for(int i=1;i<=n;i++){
            int[] next = nextDay(cells);
            String str = Arrays.toString(next);
            if(!hashSet.contains(str)){
                size++;
                hashSet.add(str);
            }else{
                hasCycle=true;
                break;
            }
            cells = next;
        }
        
        
        if(hasCycle){
            n%=size;
            for(int i=0;i<n;i++){
                cells = nextDay(cells);
            } 
        }
        return cells;
    
    }
    
    private int[] nextDay(int[] cells){
        int[] tmp = new int[cells.length];
        for(int i=1;i<cells.length-1;i++){
            tmp[i]=cells[i-1]==cells[i+1]?1:0;
        }
        return tmp;
    }
}
