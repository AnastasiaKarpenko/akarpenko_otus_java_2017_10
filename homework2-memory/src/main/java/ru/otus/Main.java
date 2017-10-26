package ru.otus;

/**
 * Created by anastasia on 23/10/2017.
 */

import java.lang.management.ManagementFactory;

import static ru.otus.MemoryEstimator.estimateSize;

@SuppressWarnings({"RedundantStringConstructorCall", "InfiniteLoopStatement"})
public class Main {
    public static void main(String... args) throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());
        while (true) {
            estimateSize(new String("Hello world"));
            estimateSize(new Object());
            Thread.sleep(1000);
        }


    }

}

