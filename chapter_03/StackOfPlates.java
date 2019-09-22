import java.util.ArrayList;
import java.util.Stack;

/**
 * Solution to exercise 3-3 from Cracking the Coding Interview, 6th edition.
 */
public class StackOfPlates {

    // Max items to push in stack before starting a new one
    private static final int STACK_CAPACITY = 8;

    private ArrayList<Stack<Integer>> plateStack;
    private int stacks;
    private int size;

    /**
     * Creates a new stack 'of plates'.
     */
    public StackOfPlates() {
        this.plateStack = new ArrayList<>();
        this.plateStack.add(new Stack<>());
        this.stacks = 0;
        this.size = 0;
    }

    /**
     * Pushes the specified item onto the stack.
     *
     * @param item The item to push.
     */
    public void push(int item) {

        Stack<Integer> stack = plateStack.get(stacks);
        if (stack.size() >= STACK_CAPACITY) {
            // Top stack became full, create a new one
            Stack<Integer> newStack = new Stack<>();
            newStack.add(item);
            plateStack.add(newStack);
            stacks++;
        } else {
            // Otherwise, insert item into top stack.
            stack.add(item);
        }
        size++;
    }

    /**
     * Returns, but does not remove, the top item in the stack, or null if the stack
     * is empty.
     *
     * @return The top item, or null if the stack is empty.
     */
    public Integer peek() {
        Stack<Integer> top = plateStack.get(stacks);
        return !top.isEmpty() ? top.peek() : null;
    }

    /**
     * Pops the top item from the stack and returns it, or null if the stack is empty.
     *
     * @return The top item, or null if the stack is empty.
     */
    public Integer pop() {

        Stack<Integer> top = plateStack.get(stacks);
        // Stack becomes empty, need to delete it
        if (stacks == 0 && top.isEmpty())
            return null;

        // Remove item from stack and return it
        Integer i = top.pop();
        if (top.isEmpty() && stacks != 0)
            plateStack.remove(stacks--);
        size--;

        return i;
    }

    /**
     * Pops the top item from the specified sub-stack and returns it, or null if the stack
     * is empty.
     *
     * @param index The sub-stack to pop from.
     * @return The sub-stack's popped item, or null if stack is empty.
     * @throws IllegalArgumentException If the index specified is out of range.
     */
    public Integer popAt(int index) {

        // Validate specified index
        if (index < 0 || index > stacks)
            throw new IllegalArgumentException("The specified index is out of range.");
        // Return null if stack is empty
        if (size == 0)
            return null;

        // Remove top item to return back
        Stack<Integer> stack = plateStack.get(index);
        Integer i = stack.remove(stack.size() - 1);
        // If sub-stack becomes empty, delete it from plate stack
        if (stack.isEmpty() && stacks != 0) {
            plateStack.remove(index);
            stacks--;
        }
        size--;

        return i;
    }

    /**
     * Returns the size of the stack.
     *
     * @return The stack size.
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if the stack is empty, false if not.]
     *
     * @return True if stack is empty, false if not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        StackOfPlates stack = new StackOfPlates();
        for (int i = 1; i <= 10; i++) {
            stack.push(i * 2);
            System.out.printf("Top: %d | Size: %d | isEmpty: %s%n", stack.peek(), stack.size(), stack.isEmpty());
        }
        for (int i = 1; i <= 12; i++) {
            Integer k = stack.popAt(0);
            System.out.println("Popped item: " + k);
            System.out.printf("Top: %d | Size: %d | isEmpty: %s%n", stack.peek(), stack.size(), stack.isEmpty());
        }
    }

}
