class Solution {
    public int totalFruit(int[] fruits) {
        int firstFruitType = 0, secondFruitType=0;
        int firstFruitCount = 0, secondFruitCount=0; //though firstFruitCount is not needed.
        int current_max=0, max=0;

        for(int fruit: fruits){
            //UPDATING CURRENT MAX HERE.
            //if current fruit is of the same type we are holding.
            if(fruit==firstFruitType || fruit==secondFruitType){
                current_max+=1;
            }else{ //if it's a new fruitType.
                current_max=secondFruitCount+1;
            }

            //updating the firstType and secondType fruits.
            if(fruit==secondFruitType){ //if current fruit is secondFruitType.
                secondFruitCount+=1;
            }else{ //if current fruit type is of firstFruitType or new fruit.
                firstFruitType = secondFruitType;
                secondFruitType=fruit;
                secondFruitCount=1;
            }

            max=Math.max(current_max,max); //update the max.


        }

        return max;
    }
}
