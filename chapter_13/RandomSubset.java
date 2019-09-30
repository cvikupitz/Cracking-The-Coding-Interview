import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Solution to exercise 13-8 from Cracking the Coding Interview, 6th edition.
 */
public class RandomSubset {

    /**
     * Returns a randomized subset of the given list of integers.
     *
     * @param list The {@link List} to create a subset from.
     * @return The generated subset.
     */
    public static List<Integer> getRandomSubset(List<Integer> list) {

        Random r = new Random();
        return list.stream()
                .filter(i -> r.nextBoolean())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 8; i++)
            list.add(i);

        List<Integer> subset = getRandomSubset(list);
        System.out.print("Subset generated: ");
        for (Integer x : subset)
            System.out.printf("%d ", x);
        System.out.println();
    }
}
