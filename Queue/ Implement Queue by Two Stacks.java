public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       // do initialization if necessary
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    public void stack2ToStack1() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
    
    public void push(int element) {
        // write your code here
        stack2.push(element);
    }

    public int pop() {
        // write your code here
        if (stack1.isEmpty()) {
            this.stack2ToStack1();
        }
        return stack1.pop();
    }

    public int top() {
        // write your code here
        if (stack1.isEmpty()) {
            this.stack2ToStack1();
        }
        return stack1.peek();
    }
}