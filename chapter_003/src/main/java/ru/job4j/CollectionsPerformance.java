package ru.job4j;

import java.util.*;

/**
 * Class to test the collection's speed.
 */
public class CollectionsPerformance {

    /**
     * Main methos of the class.
     * @param args arguments
     */
    public static void main(String[] args) {

        List<String> arraylist = new ArrayList<String>();
        List<String> linkedlist = new LinkedList<String>();
        Set<String> treeset = new TreeSet<String>();

        CollectionsPerformance collectionsPerformance = new CollectionsPerformance();

        System.out.println("time of addition for arraylist = " + collectionsPerformance.addToCollection(arraylist, 500 ));
        System.out.println("removal time for arraylist = " + collectionsPerformance.deleteFromCollection(arraylist, 50 ));

        System.out.println("time of addition for linkedlist = " + collectionsPerformance.addToCollection(linkedlist, 500 ));
        System.out.println("removal time for linkedlist = " + collectionsPerformance.deleteFromCollection(linkedlist, 50 ));

        System.out.println("time of addition for treeset = " + collectionsPerformance.addToCollection(treeset, 500 ));
        System.out.println("removal time for treeset = " + collectionsPerformance.deleteFromCollection(treeset, 50 ));
    }
    /**
     * Method to add the elements to the collection.
     * @param collection collection.
     * @param amount number of the elements.
     * @return method's work time.
     */
    public long addToCollection(Collection<String> collection, int amount) {
       long startTime = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            collection.add(String.valueOf(i));
        }
       return System.nanoTime()- startTime;

    }

    /**
     * Method to delete the elements from the collection.
     * @param collection collection.
     * @param amount number of the elements.
     * @return method's work time.
     */
    public long deleteFromCollection(Collection<String> collection, int amount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            Iterator iterator = collection.iterator();
            if (iterator.hasNext()){
                iterator.next();
                iterator.remove();

            }

        }
        return System.nanoTime()- startTime;
    }

}
