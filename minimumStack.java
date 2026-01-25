/*
Design a stack class that supports the push, pop, top, and getMin operations.

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.

Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]
Output: [null,null,null,null,0,null,2,1]

Explanation:
MinStack minStack = new MinStack();
minStack.push(1);
minStack.push(2);
minStack.push(0);
minStack.getMin(); // return 0
minStack.pop();
minStack.top();    // return 2
minStack.getMin(); // return 1
*/

class MinStack {
    ArrayList<Integer> minStack;
    int top;
    public MinStack() {
        minStack = new ArrayList<>();
        top = 0;
    }
    
    public void push(int val) {
        minStack.add(val);
        top++;
    }
    
    public void pop() {
        minStack.remove(top - 1);
        top--;
    }
    
    public int top() {
        return minStack.get(top - 1);
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int num : minStack){
            if(min > num){
                min = num;
            }
        }
        return min;
    }
}
