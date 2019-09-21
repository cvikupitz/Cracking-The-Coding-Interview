/**
 * Solution to exercise 3-2 from Cracking the Coding Interview, 6th edition.
 */
public class StackMin {

    /**
     * Inner class that represents a node in the stack.
     */
    private class Node {

        private final Integer item;
        private final Integer min;
        private final Node next;

        /**
         * Creates a new stack node.
         *
         * @param item The node's payload.
         * @param min The minimum element in this sub-stack.
         * @param next Pointer to the next node.
         * */
        Node(int item, int min, Node next) {
            this.item = item;
            this.min = min;
            this.next = next;
        }

        /**
         * Returns the node's payload.
         *
         * @return The payload.
         */
        Integer getItem() {
            return item;
        }

        /**
         * Returns the node's minimum element.
         *
         * @return The minimum element.
         */
        Integer getMin() {
            return min;
        }

        /**
         * Returns the pointer to the next node.
         *
         * @return The next node.
         */
        Node getNext() {
            return next;
        }

    }

    private Node top;

    /**
     * Creates a new stack.
     */
    public StackMin() {
        this.top = null;
    }

    /**
     * Pushes the specified item onto the stack.
     *
     * @param item The item to push.
     */
    public void push(int item) {

        Node temp = null;

        if (top == null) {
            // Edge case: stack is empty
            temp = new Node(item, item, null);
        } else {
            // Calculate new minimum, insert new node
            int min = (item < top.getMin()) ? item : top.getMin();
            temp = new Node(item, min, top);
        }
        top = temp;
    }

    /**
     * Returns, but does not remove, the stack's top item, or null if the stack is empty.
     *
     * @return The top item, or null if stack is empty.
     */
    public Integer peek() {
        return top != null ? top.getItem() : null;
    }

    /**
     * Returns the minimum item in the stack, or null if the stack is empty.
     *
     * @return The minimum item, or null if stack is empty.
     */
    public Integer min() {
        return top != null ? top.getMin() : null;
    }

    /**
     * Returns true if the stack is empty, false if not.
     *
     * @return True if the stack is empty, false if not.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Pops and returns the top item from the stack, or returns null if the stack is empty.
     *
     * @return The popped item, or null if stack is empty.
     */
    public Integer pop() {

        // Stack is empty, return null
        if (top == null)
            return null;
        // Return top item, reassign the top node
        Integer i = top.getItem();
        top = top.getNext();

        return i;
    }

    public static void main(String[] args) {

        StackMin stack = new StackMin();
        stack.push(14);
        stack.push(22);
        stack.push(25);
        stack.push(9);
        stack.push(18);
        stack.push(4);
        stack.push(16);
        stack.push(45);
        stack.push(33);
        stack.push(99);

        while (!stack.isEmpty()) {
            System.out.printf("Next Item: %d | Min: %d\n", stack.peek(), stack.min());
            stack.pop();
        }
    }

}
