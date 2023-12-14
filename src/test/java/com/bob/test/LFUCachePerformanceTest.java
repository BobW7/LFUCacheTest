package com.bob.test;

import com.bob.LFUCache;
import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

/**
 * 性能测试
 */
public class LFUCachePerformanceTest {
    private static final int CACHE_SIZE = 1;
    private static final int TEST_DATA_SIZE = 1000000;
    private static final int TEST_ITERATIONS = 1000000;

    private LFUCache<String, Object> cache;

    public LFUCachePerformanceTest() {
        cache = new LFUCache<>(CACHE_SIZE);
    }

    /**
     * 测试存取时间
     */
    @Test
    public void testAccessTime() {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            String key = "key" + random.nextInt(TEST_DATA_SIZE);
            getObjectFromCache(key);
        }

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        double averageTime = (double) totalTime / TEST_ITERATIONS;

        System.out.println("Average access time: " + averageTime + " nanoseconds");
    }

    /**
     * 测试缓存命中率
     */
    @Test
    public void testCacheHitRate() {
        int cacheHits = 0;

        Random random = new Random();
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            String key = "key" + random.nextInt(TEST_DATA_SIZE);
            if (getObjectFromCache(key) != null) {
                cacheHits++;
            }
        }
        double hitRate = (double) cacheHits / TEST_ITERATIONS * 100;
        System.out.println("Cache hit rate: " + hitRate + "%");
    }

    private Object getObjectFromCache(String key) {
        Object value = cache.get(key);
        if (value == null) {
            value = fetchObjectFromDataSource(key);
            cache.put(key, value);
        }
        return value;
    }

    public Object fetchObjectFromDataSource(String key) {
        // 模拟从数据源获取对象
        return new Object();
    }
}