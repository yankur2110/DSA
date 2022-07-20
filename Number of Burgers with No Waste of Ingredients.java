class Solution {
    public List<Integer> numOfBurgers(int t, int c) {
        //simply a quadratic equation.
        //just mind few contraints for tomatoSlices and cheeseSlices.
        //if they are satisfied, then it is possible otherwise not.
        return (t%2==0 && t>=2*c && t<=4*c)? Arrays.asList(t/2 - c, 2*c-t/2 ):new ArrayList<>();
    }
}
