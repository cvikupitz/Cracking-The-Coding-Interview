import java.util.LinkedList;

/**
 * Solution to exercise 3-4 from Cracking the Coding Interview, 6th edition.
 */
public class MyQueue {

    private LinkedList<Integer> left;
    private LinkedList<Integer> right;

    /**
     * Creates a new Queue.
     */
    public MyQueue() {
        this.left = new LinkedList<>();
        this.right = new LinkedList<>();
    }

    /**
     * Inserts the specified item into the back of the queue.
     *
     * @param item The element to insert.
     */
    public void enqueue(Integer item) {
        left.push(item);
    }

    /*
     * Moves all items from the left stack into the right stack.
     *
     * Performed before all peeks and removals to imitate a FIFO queue.
     */
    private void transferItems() {
        while (!left.isEmpty()) {
            Integer i = left.pop();
            right.push(i);
        }
    }

    /**
     * Returns, but does not remove, the first item in the queue, or null if the queue is empty.
     *
     * @return The first item, or null if queue is empty.
     */
    public Integer peek() {
        transferItems();
        return !right.isEmpty() ? right.peek() : null;
    }

    /**
     * Dequeues and returns the first item from the queue, or null if the queue is empty.
     *
     * @return The dequeued item, or null if the queue is empty.
     */
    public Integer dequeue() {
        transferItems();
        return !right.isEmpty() ? right.pop() : null;
    }

    /**
     * Returns the size of the queue.
     *
     * @return The queue's size.
     */
    public int size() {
        return left.size() + right.size();
    }

    /**
     * Returns true if the queue is empty, false if not.
     *
     * @return True if queue is empty, false if not.
     */
    public boolean isEmpty() {
        return left.isEmpty() && right.isEmpty();
    }

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();
        for (int i = 1; i <= 15; i++)
            queue.enqueue(i * 5);

        while (!queue.isEmpty())
            System.out.printf("%d%n", queue.dequeue());
    }

}
