class Solution {

    //corresponding to {"N","E","S","W"} directions.
    int[][] actualDirctions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    int dirIndex = 0;
    public boolean isRobotBounded(String s) {

        ///{x,y} represents the coordinates of bot.
        int i=0, x=0, y=0;

        //now start visiting.
        while(i<s.length()){

            if(s.charAt(i)=='G'){
                x+=actualDirctions[dirIndex][0];
                y+=actualDirctions[dirIndex][1];
            }else if(s.charAt(i)=='L'){
                dirIndex = ((dirIndex-1)+4)%4;
            }else{
                dirIndex = (dirIndex+1)%4;
            }
            i++;

        }

        //if bot is at starting position or if he is facing any other direction (than north). Return true.
        return  x == 0 && y == 0 || dirIndex > 0;
    }
}
