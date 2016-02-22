//use two stacks to implement a queue's actions.

public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       // stack2 is used to push elements
       // stack1 is used to pop and peek
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    public void stack2ToStack1() {
        //push the elements in stack2 to stack1 until stack2 is empty.
        //So that the earlier element that pushed into stack 2 will be poped out first in stack1

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
    
    public void push(int element) {
        stack2.push(element);
    }

    public int pop() {
        if (stack1.isEmpty()) {
            this.stack2ToStack1();
        }
        return stack1.pop();
    }

    public int top() {
        if (stack1.isEmpty()) {
            this.stack2ToStack1();
        }
        return stack1.peek();
    }
}