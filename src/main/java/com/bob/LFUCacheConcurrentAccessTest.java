package com.bob;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 并发测试
 */
public class LFUCacheConcurrentAccessTest {

    private static final int THREAD_COUNT = 5;
    private static final int ITERATIONS_PER_THREAD = 100;

    @Test
    public void testConcurrentAccess() throws InterruptedException {
        LFUCache<Integer, String> cache = new LFUCache<>(5);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        // Submit tasks to the executor service
        for (int i = 0; i < THREAD_COUNT; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < ITERATIONS_PER_THREAD; j++) {
                    int key = j % 5;

                    // Put key-value pair into the cache
                    cache.put(key, "Value " + key);

                    // Get value from the cache
                    String value = cache.get(key);

                    System.out.println("Thread " + Thread.currentThread().getId() +
                            " - Key: " + key + ", Value: " + value);

                    // Assert the value retrieved from the cache
                    Assert.assertEquals("Value " + key, value);
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
    }
}
