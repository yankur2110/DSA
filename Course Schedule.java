class Solution {
    //take 1 for yes, 2 for no.
    int[] courseCanBeTaken;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        courseCanBeTaken  = new int[numCourses];
        int[] visitedArray = new int[numCourses];
        for(int i=0;i<numCourses; i++){
            if(!canItakeThis(i, prerequisites, visitedArray)){
                return false;
            }
        }
        return true;
    }
    
    public boolean canItakeThis(int num, int[][] prerequisites, int[] visitedArray){
        if(courseCanBeTaken[num]==1)
            return true;
        if(courseCanBeTaken[num]==2)
            return false;
        
        visitedArray[num]=1;
        for(int i=0;i<prerequisites.length; i++){
            if(prerequisites[i][0]==num){
                
                if(visitedArray[prerequisites[i][1]]==1){
                     if(courseCanBeTaken[prerequisites[i][1]]!=1)
                        return false;
                }
                
                if(!canItakeThis(prerequisites[i][1],prerequisites, visitedArray))
                    courseCanBeTaken[prerequisites[i][1]]=2;
            }               
        }
        
        visitedArray[num]=0;
        courseCanBeTaken[num]=1;
        return true;
        
    }
}
