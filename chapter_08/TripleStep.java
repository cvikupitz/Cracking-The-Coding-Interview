/**
 * Solution to exercise 8-1 from Cracking the Coding Interview, 6th edition.
 */
public class TripleStep {

    // Local method strictly used for recursive calling and memoization
    private static int hopStairs(int steps, int[] cache) {

        // Check base cases
        if (steps < 0)
            return 0;
        if (steps == 0 || steps == 1)
            return 1;

        // Check local memoization array for result
        if (cache[steps] != -1)
            return cache[steps];

        // And this is where the recursion happens
        cache[steps] = hopStairs(steps - 1, cache) + hopStairs(steps - 2, cache) + hopStairs(steps - 3, cache);
        return cache[steps];
    }

    public static int hopStairs(int steps) {

        if (steps <= 0)
            return 0;

        int[] cache = new int[steps + 1];
        for (int i = 0; i < steps + 1; i++)
            cache[i] = -1;

        return hopStairs(steps, cache);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++)
            System.out.printf("%d steps: %d\n", i, hopStairs(i));
    }
}
