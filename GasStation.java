class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        
        for(int i=0;i<gas.length;i++){
            int prev=i;
            int gasFuel=gas[i];
            int count=0;
            
            for(int j=(i+1)%gas.length;count<gas.length;count++){
                
                int fuel_available_on_reaching_jth_index_station = gasFuel-cost[prev];
                
                if(fuel_available_on_reaching_jth_index_station>=0){
                    gasFuel = fuel_available_on_reaching_jth_index_station + gas[j];
                    prev=j;
                }else{
                    break;
                }
                
                j=(j+1)%gas.length;
            }
            
            if(count==gas.length){
                return i;
            }
            
            if(i==gas.length-1){
                return -1;
            }
            
        }
        
        return -1;
    }
}