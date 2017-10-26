package ru.otus;

/**
 * Created by anastasia on 26/10/2017.
 */
public class MemoryEstimator {

    private static Runtime runtime = Runtime.getRuntime();
    private static long memoryBeforeAllocation;
    private static long memoryAfterAllocation;
    private static int i = 0;
    private static long size = 10000000;

    public static void estimateSize(String string) {
        System.gc();
        memoryBeforeAllocation = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory before object allocation:" + memoryBeforeAllocation);

        String[] strings = new String [(int)size];

        for (; i<size; i++) {
            strings[i] = new String (string);
        }

        System.out.println("Created " + size + " strings");

        System.gc();
        memoryAfterAllocation = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory after object allocation:" + memoryAfterAllocation);

        System.out.println("String size is:");
        System.out.println( (memoryAfterAllocation - memoryBeforeAllocation) / size);

    }

    public static void estimateSize(Object object) {
        System.gc();
        memoryBeforeAllocation = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory before object allocation:" + memoryBeforeAllocation);

        Object[] objects = new Object [(int)size];

        for (i=0; i<size; i++) {
            objects[i] = new Object ();
        }
        System.out.println("Created " + size + " objects");

        System.gc();
        memoryAfterAllocation = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory after object allocation:" + memoryAfterAllocation);

        System.out.println("Object size is:");
        System.out.println( (memoryAfterAllocation - memoryBeforeAllocation) / size);

    }

}
