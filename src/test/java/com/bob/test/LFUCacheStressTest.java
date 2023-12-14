package com.bob.test;

import com.bob.LFUCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertNotNull;

/**
 * 压力测试（结合数据驱动）
 */
@RunWith(Parameterized.class)
public class LFUCacheStressTest {
    private final int cacheSize;
    private final int numberOfOperations;

    public LFUCacheStressTest(int cacheSize, int numberOfOperations) {
        this.cacheSize = cacheSize;
        this.numberOfOperations = numberOfOperations;
    }

    /**
     * 数据驱动
     * @return 对象数组集合，每个集合两个元素，表示缓存大小和操作次数
     */
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10, 100000},   // Cache size: 10, Number of operations: 100,000
                {100, 1000000}, // Cache size: 100, Number of operations: 1,000,000
                {1000, 10000000} // Cache size: 1000, Number of operations: 10,000,000
        });
    }

    @Test
    public void testLFUCacheUnderStress() {
        LFUCache<String, String> cache = new LFUCache<>(cacheSize);

        for (int i = 0; i < numberOfOperations; i++) {
            String key = "key" + i;
            String value = "value" + i;
            cache.put(key, value);
            String retrievedValue = cache.get(key);
            assertNotNull(retrievedValue);
        }
    }
}