package ru.otus;


import java.util.ArrayList;

/**
 * Created by anastasia on 26/10/2017.
 */
public class MemoryEstimator {

    public  Object [] estimateObjectSize(Object object, int size) {
        long memoryBeforeAllocation;
        long memoryAfterAllocation;
        Object [] objects;

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        memoryBeforeAllocation = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory before object allocation:" + memoryBeforeAllocation);

        if (object instanceof String) {
            objects = new String [size];
            for (int i=0; i<size; i++) {
                objects[i] = new String((String) object);
            }
            System.out.println("Created " + size + " strings");
        }  else {
            objects = new Object [size];

            for (int i=0; i<size; i++) {
                objects[i] = new Object ();
            }

            System.out.println("Created " + size + " objects");
        }

        runtime.gc();

        memoryAfterAllocation = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Memory after object allocation: " + memoryAfterAllocation);
        System.out.println("Array size is: " + (memoryAfterAllocation - memoryBeforeAllocation));
        System.out.println("Object size is: " + ((memoryAfterAllocation - memoryBeforeAllocation) / size));
        System.out.println("--------------------------------------------------");
        System.out.println("");

        return objects;
    }

}