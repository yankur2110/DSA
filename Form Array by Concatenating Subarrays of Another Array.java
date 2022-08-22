class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int g_index=0;

        for(int i=0;i<nums.length;i++){
            if(g_index>=groups.length) return true;

            int[] reqd_arr = groups[g_index];

            if(reqd_arr[0]==nums[i]){
                int k=0;
                int j=i;

                while(k<reqd_arr.length && j<nums.length && reqd_arr[k]==nums[j]){
                    k++;
                    j++;
                }

                if(k==reqd_arr.length){
                    g_index++;
                    i=j-1;
                }
            }
        }

        return g_index>=groups.length;
    }
}
