package ru.otus;

/**
 * Created by anastasia on 23/10/2017.
 */

import java.lang.management.ManagementFactory;

@SuppressWarnings({"RedundantStringConstructorCall", "InfiniteLoopStatement"})
public class Main {
    public static void main(String... args) throws InterruptedException {
        MemoryEstimator memoryEstimator = new MemoryEstimator();
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());
            memoryEstimator.estimateObjectSize(new String(""), 1000000);
            memoryEstimator.estimateObjectSize(new String(""), 2000000);

            memoryEstimator.estimateObjectSize(new Object(), 1000000);
            memoryEstimator.estimateObjectSize(new Object(), 2000000);

    }
}

