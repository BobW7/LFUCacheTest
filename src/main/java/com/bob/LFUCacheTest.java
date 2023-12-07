package com.bob;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LFUCacheTest {

    @Test
    void testLFUCacheWithIntegerValueShouldPass() {
        LFUCache<Integer, Integer> lfuCache = new LFUCache<>(5);
        lfuCache.put(1, 10);
        lfuCache.put(2, 20);
        lfuCache.put(3, 30);
        lfuCache.put(4, 40);
        lfuCache.put(5, 50);

        // get方法调用将键为1的频率增加1
        Assertions.assertEquals(10, lfuCache.get(1));

        // 这个操作将移除键为2的值
        lfuCache.put(6, 60);

        // 因为键为2的值已被移除，所以应返回null
        Assertions.assertEquals(null, lfuCache.get(2));

        // 应返回60
        Assertions.assertEquals(60, lfuCache.get(6));

        // 这个操作将移除键为3的值
        lfuCache.put(7, 70);

        Assertions.assertEquals(null, lfuCache.get(2));
        Assertions.assertEquals(70, lfuCache.get(7));
    }

    @Test
    void testLFUCacheWithStringValueShouldPass() {
        LFUCache<Integer, String> lfuCache = new LFUCache<>(5);
        lfuCache.put(1, "Alpha");
        lfuCache.put(2, "Beta");
        lfuCache.put(3, "Gamma");
        lfuCache.put(4, "Delta");
        lfuCache.put(5, "Eplison");

        // get方法调用将键为1的频率增加1
        Assertions.assertEquals("Alpha", lfuCache.get(1));

        // 这个操作将移除键为2的值
        lfuCache.put(6, "Digamma");

        // 因为键为2的值已被移除，所以应返回null
        Assertions.assertEquals(null, lfuCache.get(2));

        // 应返回字符串"Digamma"
        Assertions.assertEquals("Digamma", lfuCache.get(6));

        // 这个操作将移除键为3的值
        lfuCache.put(7, "Zeta");

        Assertions.assertEquals(null, lfuCache.get(2));
        Assertions.assertEquals("Zeta", lfuCache.get(7));
    }

    /**
     * 测试addNodeWithUpdatedFrequency方法
     *
     * @author yuluo
     */
    @Test
    void testAddNodeWithUpdatedFrequency() {
        LFUCache<Integer, String> lfuCache = new LFUCache<>(3);
        lfuCache.put(1, "beijing");
        lfuCache.put(2, "shanghai");
        lfuCache.put(3, "gansu");

        Assertions.assertEquals("beijing", lfuCache.get(1));

        lfuCache.put(1, "shanxi");

        Assertions.assertEquals("shanxi", lfuCache.get(1));
    }
}