class Solution {
    public int findMinFibonacciNumbers(int k) {
        TreeSet<Integer> set = new TreeSet<>();

        if(k<2) return k;
        int a=0, b=1;
        //total number of elements would be logK.
        //each would take logK time in insertion hence TC would be log(logK)
        while(b<k){
            b=a+b;
            set.add(b);
            a=b-a;
        }

        int res=0, maxFib;
        //logK here as well.
        while(k>0){
            maxFib=set.floor(k);
            k-=maxFib;
            res++;
        }

        return res;
    }
}
