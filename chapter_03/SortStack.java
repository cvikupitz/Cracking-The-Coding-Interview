import java.util.Stack;

/**
 * Solution to exercise 3-5 from Cracking the Coding Interview, 6th edition.
 */
public class SortStack {

    private Stack<Integer> theStack;
    private boolean sorted;

    /**
     * Creates a new sorted stack.
     */
    public SortStack() {
        this.theStack = new Stack<>();
        this.sorted = false;
    }

    /**
     * Pushes the specified item onto the stack.
     *
     * @param item The item to push.
     */
    public void push(int item) {
        theStack.push(item);
        sorted = false;
    }

    /*
     * Sorts all items in the stack such that the items are ordered from least to greatest
     * (the minimum item is on top, maximum is on the bottom).
     */
    private void sort() {

        Stack<Integer> temp = new Stack<>();

        while (!theStack.isEmpty()) {
            Integer x = theStack.pop();
            // Swap items from stacks until items are ordered
            while (!temp.isEmpty() && temp.peek() > x)
                theStack.push(temp.pop());
            temp.push(x);
        }

        // Return items from temporary stack to original
        while (!temp.isEmpty())
            theStack.push(temp.pop());
    }

    /**
     * Returns, but does not remove, the stack's top item, or null if the stack is empty.
     *
     * @return The top item, or null if stack is empty.
     */
    public Integer peek() {

        if (theStack.isEmpty())
            return null;
        if (!sorted) {
            sort();
            sorted = true;
        }

        return theStack.peek();
    }

    /**
     * Pops and returns the top item from the stack, or returns null if the stack is empty.
     *
     * @return The popped item, or null if stack is empty.
     */
    public Integer pop() {

        if (theStack.isEmpty())
            return null;
        if (!sorted) {
            sort();
            sorted = true;
        }

        return theStack.pop();
    }

    /**
     * Returns the size of the stack.
     *
     * @return The stack's size.
     */
    public int size() {
        return theStack.size();
    }

    /**
     * Returns true if the stack is empty, false if not.
     *
     * @return True if stack is empty, false if not.
     */
    public boolean isEmpty() {
        return theStack.isEmpty();
    }

    public static void main(String[] args) {

        SortStack stack = new SortStack();

        stack.push(33);
        stack.push(12);
        stack.push(6);
        stack.push(2);
        stack.push(29);
        stack.push(18);
        stack.push(37);
        stack.push(20);
        stack.push(30);
        stack.push(45);

        System.out.printf("Top: %d | size: %d | isEmpty: %s%n", stack.peek(), stack.size(), stack.isEmpty());
        while (!stack.isEmpty()) {
            System.out.printf("Popped %d from stack%n", stack.pop());
            System.out.printf("Top: %d | size: %d | isEmpty: %s%n", stack.peek(), stack.size(), stack.isEmpty());
        }
    }

}
