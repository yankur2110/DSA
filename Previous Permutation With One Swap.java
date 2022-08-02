class Solution {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length-1;

        for(int i=n;i>0;i--){
            if(arr[i-1]>arr[i]){
                map.put(arr[i],i);
                swap(i-1,findIndexWithValLessThan(arr[i-1], arr),arr);
                break;
            }else{
                map.put(arr[i],i);
            }
        }
        return arr;
    }

    public void swap(int index1, int index2, int[] arr){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public int findIndexWithValLessThan(int val, int[] arr){
        for(int i=arr.length-1;i>0;i--){
            if(arr[i]<val){
                while(arr[i]==arr[i-1])
                    i--;
                return i;
            }
        }
        return 0;
    }


}
