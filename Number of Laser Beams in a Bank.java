class Solution {
    public int numberOfBeams(String[] bank) {

        int[] arr = new int[bank.length];

        for(int i=0;i<bank.length;i++){
            String floorDeviceRepresentation = bank[i];
            int count=0;
            for(int j=0;j<floorDeviceRepresentation.length();j++){
                if(floorDeviceRepresentation.charAt(j)=='1'){
                    count++;
                }
            }
            arr[i]=count;
        }

        //processing starts.
        int num=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==0)
                continue;

            int devInJthRow=0;
            int j=i+1;
            while(j<arr.length){
                if(arr[j]!=0){
                    devInJthRow=arr[j];
                    break;
                }
                j++;
            }

            num+= (arr[i]*devInJthRow);
            i=j-1;
        }

        return num;

    }
}
