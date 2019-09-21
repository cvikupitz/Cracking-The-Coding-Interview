import java.util.LinkedList;

/**
 * Solution to exercise 3-6 from Cracking the Coding Interview, 6th edition.
 */
public class AnimalShelter {

    /**
     * An abstract class representing a generic animal.
     */
    abstract static class Animal {

        private long timeStamp;
        private final String name;

        /**
         * Creates a new animal.
         *
         * @param name The name to assign.
         */
        Animal(String name) {
            this.name = name;
        }

        /**
         * Returns the animal's assigned name.
         *
         * @return The animal's name.
         */
        String getName() {
            return name;
        }

        /**
         * Sets the animal's ordering time stamp to the specified time stamp.
         *
         * @param timeStamp The time stamp to assign.
         */
        void setTimeStamp(long timeStamp) {
            this.timeStamp = timeStamp;
        }

        /**
         * Returns the animal's arriving time stamp value.
         *
         * @return The animal's time stamp.
         */
        long getTimeStamp() {
            return timeStamp;
        }

        /**
         * Returns the animal type.
         *
         * @return The animal type.
         */
        abstract String getType();

    }

    /**
     * Class that represents a cat in the animal shelter.
     */
    static class Cat extends Animal {

        /**
         * Creates a new cat.
         */
        Cat(String name) {
            super(name);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        String getType() {
            return "Cat";
        }
    }

    /**
     * Class that represents a dog in the animal shelter.
     */
    static class Dog extends Animal {

        /**
         * Creates a new dog.
         */
        Dog(String name) {
            super(name);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        String getType() {
            return "Dog";
        }
    }

    private LinkedList<Cat> catQueue;
    private LinkedList<Dog> dogQueue;
    private long counter;

    /**
     * Creates a new animal shelter.
     */
    public AnimalShelter() {
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
        this.counter = 0L;
    }

    /**
     * Inserts the specified animal into the animal shelter.
     *
     * @param animal The animal to enqueue.
     */
    public void enqueue(Animal animal) {

        animal.setTimeStamp(counter++);
        // Inserts cat into cat queue
        if (animal instanceof Cat)
            catQueue.add((Cat)animal);
        // Inserts dog into dog queue
        else if (animal instanceof Dog)
            dogQueue.add((Dog)animal);
    }

    /**
     * Returns the first cat in the animal shelter's cat queue, or null if it's empty.
     *
     * @return The next cat in the queue.
     */
    public Cat dequeueCat() {
        return catQueue.pollFirst();
    }

    /**
     * Returns the first dog in the animal shelter's cat queue, or null if it's empty.
     *
     * @return The next dog in the queue.
     */
    public Dog dequeueDog() {
        return dogQueue.pollFirst();
    }

    /**
     * Returns the next soonest arrived animal in the animal shelter's queues, or null if all the
     * queues are empty.
     *
     * @return The next animal in the queue.
     */
    public Animal dequeueAny() {

        Cat cat = catQueue.peek();
        Dog dog = dogQueue.peek();

        // Return null if both queues empty
        if (cat == null && dog == null)
            return null;
        // Dog queue is empty, return next cat
        if (cat != null && dog == null)
            return catQueue.pollFirst();
        // Cat queue is empty, return next dog
        if (cat == null)
            return dogQueue.pollFirst();

        // Return next animal with the lower time stamp
        return cat.getTimeStamp() < dog.getTimeStamp() ?
                catQueue.pollFirst() : dogQueue.pollFirst();
    }

    /**
     * Returns true if the animal shelter is empty (has no more animals), false if otherwise.
     *
     * @return True if shelter is empty, false if not.
     */
    public boolean isEmpty() {
        return catQueue.isEmpty() && dogQueue.isEmpty();
    }

    public static void main(String[] args) {

        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(new Cat("Annie"));
        shelter.enqueue(new Cat("Boris"));
        shelter.enqueue(new Dog("Carli"));
        shelter.enqueue(new Cat("Dennis"));
        shelter.enqueue(new Cat("Emma"));
        shelter.enqueue(new Dog("Frank"));
        shelter.enqueue(new Dog("Gary"));
        shelter.enqueue(new Dog("Helen"));

        while (!shelter.isEmpty()) {
            Animal temp = shelter.dequeueAny();
            System.out.printf("Adopted %s (%s)%n", temp.getName(), temp.getType());
        }
    }

}
