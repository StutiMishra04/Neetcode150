/*
There are n cars traveling to the same destination on a one-lane highway
You are given two arrays of integers position and speed, both of length n.

position[i] is the position of the ith car (in miles)
speed[i] is the speed of the ith car (in miles per hour)

The destination is at position target miles.
A car can not pass another car ahead of it. It can only catch up to another car and then drive at the same speed as the car ahead of it.
A car fleet is a non-empty set of cars driving at the same position and same speed. A single car is also considered a car fleet.
If a car catches up to a car fleet the moment the fleet reaches the destination, then the car is considered to be part of the fleet.
Return the number of different car fleets that will arrive at the destination.

Input: target = 10, position = [1,4], speed = [3,2]
Output: 1
*/

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a,b) -> Integer.compare(b[0],a[0]));
        // this sorts the pair array based on position in desceneding order

        // so, if position = [4,1,0,7] and speed = [2,2,1,1]
        // pair is [ [4,2] , [1,2] , [0,1] , [7,1] ]
        // After sorting, pair becomes [ [7,1] , [4,2] , [1,2] , [0,1] ]

        /* if (target - position of car)/ speed matches another car's time,
        They become fleet. To do that we use stack. 
        */ 
        Stack<Double> stack = new Stack<>();
        for(int[] car: pair){
            stack.push((double) (target - car[0]) / car[1]);

            if(stack.size() >= 2 && stack.peek() <= stack.get( stack.size() - 2) )
            {
                stack.pop();
            }

            /*
            This condition has two components:
            1. stack.size >= 2 which means that we need atleast two times to compare
            the current car and the next car or fleet ahead
            2. the second condition which matches top car's time with second
            top car's time

            this condition means If the car behind arrives earlier or at the same time as 
            the fleet ahead, it will catch it → merge fleets.
            */
        }
        return stack.size();
    }
}
