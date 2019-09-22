/**
 * Solution to exercise 3-1 from Cracking the Coding Interview, 6th edition.
 */
public class ThreeInOne {

    // Default capacity to assign when omitted from constructor
    private static final int DEFAULT_CAPACITY = 10;

    private int[] stacks;
    private int[] sizes;
    private final int capacity;

    /**
     * Creates a 'three-in-one' stack.
     */
    public ThreeInOne() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates a 'three-in-one' stack with the specified capacity.
     *
     * @param capacity The sub-stack capacity.
     */
    public ThreeInOne(int capacity) {

        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        this.stacks = new int[capacity * 3];
        this.sizes = new int[] {-1, -1, -1};
        this.capacity = capacity;
    }

    /*
     * Validates the specified index, or throws an IllegalArgumentException if invalid.
     */
    private void validateIndex(int i) {
        if (i < 0 || i > 2)
            throw new IllegalArgumentException("Index must be 0, 1, or 2.");
    }

    /**
     * Pushes the specified item onto the specified sub-stack. Returns true if the push
     * was successful, false if not (sub-stack is full).
     *
     * @param item The item to push.
     * @param index The sub-stack to push onto.
     * @return True if the push was successful, false otherwise.
     * @throws IllegalArgumentException If the index specified is out of range.
     */
    public boolean push(int item, int index) {

        // Validate index and stack is not full
        validateIndex(index);
        if (sizes[index] + 1 == capacity)
            return false;

        // Insert item into sub-stack
        int k = ((index * capacity) + (++sizes[index]));
        stacks[k] = item;

        return true;
    }

    /*
     * Retrieves and returns the top item from the specified sub-stack.
     */
    private int retrieve(int i) {

        int k = ((i * capacity) + sizes[i]);
        return stacks[k];
    }

    /**
     * Returns, but does not remove, the top item from the specified sub-stack, or
     * 0 if the sub-stack is empty.
     *
     * @param index The sub-stack to peek from.
     * @return The top item from the sub-stack.
     * @throws IllegalArgumentException If the index specified is out of range.
     */
    public int peek(int index) {

        // Validate index and that sub-stack is not empty
        validateIndex(index);
        if (sizes[index] == -1)
            return 0;

       return retrieve(index);
    }

    /**
     * Pops the top item from the specified sub-stack and returns it, or 0 if the
     * sub-stack is empty.
     *
     * @param index The sub-stack to pop from.
     * @return The popped item, or 0 if the stack is empty.
     * @throws IllegalArgumentException If the index specified is out of range.
     */
    public int pop(int index) {

        // Validate index and that sub-stack is not empty
        validateIndex(index);
        if (sizes[index] == -1)
            return 0;

        // Remove and return the top item
        int i = retrieve(index);
        sizes[index]--;
        return i;
    }

    /**
     * Returns the size of the specified sub-stack.
     *
     * @param index The sub-stack index.
     * @return The sub-stack's size.
     * @throws IllegalArgumentException If the index specified is out of range.
     */
    public int size(int index) {

        validateIndex(index);
        return sizes[index] + 1;
    }

    /**
     * Returns true if the specified sub-stack is empty, false if not.
     *
     * @param index The sub-stack index to check.
     * @return True if sub-stack is empty, false if not.
     * @throws IllegalArgumentException If the index specified is out of range.
     */
    public boolean isEmpty(int index) {

        validateIndex(index);
        return sizes[index] == -1;
    }

    public static void main(String[] args) {

        ThreeInOne stack = new ThreeInOne();

        for (int i = 1; i <= 10; i++) {
            System.out.printf("[Stack 1] Top: %d | Size: %d | isEmpty: %s%n",
                    stack.peek(0), stack.size(0), stack.isEmpty(0));
            System.out.printf("[Stack 2] Top: %d | Size: %d | isEmpty: %s%n",
                    stack.peek(1), stack.size(1), stack.isEmpty(1));
            System.out.printf("[Stack 3] Top: %d | Size: %d | isEmpty: %s%n",
                    stack.peek(2), stack.size(2), stack.isEmpty(2));

            int a = i;
            int b = i * 2;
            int c = i * 3;
            stack.push(a, 0);
            stack.push(b, 1);
            stack.push(c, 2);

            System.out.printf("Pushed %d onto stack 1, %d onto stack 2, %d onto stack 3.%n", a, b, c);
        }

        for (int i = 1; i <= 12; i++) {
            System.out.printf("[Stack 1] Top: %d | Size: %d | isEmpty: %s%n",
                    stack.peek(0), stack.size(0), stack.isEmpty(0));
            System.out.printf("[Stack 2] Top: %d | Size: %d | isEmpty: %s%n",
                    stack.peek(1), stack.size(1), stack.isEmpty(1));
            System.out.printf("[Stack 3] Top: %d | Size: %d | isEmpty: %s%n",
                    stack.peek(2), stack.size(2), stack.isEmpty(2));

            int a = stack.pop(0);
            int b = stack.pop(1);
            int c = stack.pop(2);

            System.out.printf("Popped %d from stack 1, %d from stack 2, %d from stack 3.%n", a, b, c);
        }
    }

}
