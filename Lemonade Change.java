class Solution {
    public boolean lemonadeChange(int[] bills) {

        int count5=0, count10=0, amountToBeReturned=0;

        for(int i=0;i<bills.length;i++){
            amountToBeReturned=bills[i]-5;

            if(amountToBeReturned==15){
                if(count10>0 && count5>0){
                    count5--; count10--;
                }else if(count5>2){
                    count5-=3;
                }else{
                    return false;
                }
            }else if (amountToBeReturned==5){
                if(count5>0){
                    count5--;
                    count10++;
                }else{
                    return false;
                }
            }else{
                count5++;
            }
        }

        return true;
    }
}
