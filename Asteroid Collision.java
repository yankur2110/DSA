class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        //Problem is not much explanatory. In case of [-10,15] it won't collide.
        //So all possible cases are --,++,-+,+-. And only in case of +- the collision will occur.

        //code might look a bit messy because after logic, code is modified to handle few failing test cases.

        Stack<Integer> stack = new Stack<>();
        int top = 0, popped =0, toBePushed=0;

        for(int asteroid : asteroids){
            if(top==1 && asteroid<0){ //only if positive element is on the top and incoming asteriod is -ve, then collision is possible.
                    do{
                        popped = stack.pop();
                        toBePushed = popped>Math.abs(asteroid)?popped: asteroid;
                        if(popped==Math.abs(asteroid)) break; //if it's of same size, handle differently.
                    }while(toBePushed<0 && !stack.isEmpty() && stack.peek()>=0); //keep on popping the elmenent... if incoming asteroid is negative and greater till the time stack is not empty.

                if(popped!=Math.abs(asteroid)) stack.push(toBePushed);
            }else{
                stack.push(asteroid);
            }

            if(!stack.isEmpty())
                top = stack.peek()>0?1:-1;
            else
                top = 0;

        }
        return stack.stream().mapToInt(i->i).toArray();
    }
}
