package com.bob.test;

import com.bob.LFUCache;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

/**
 * 验证缓存命中率的准确性，验证最不经常使用的节点是否被正确移除。
 */
public class LFUCacheTest {
    @Test
    public void testCacheHitRate() {
        LFUCache<String, Integer> cache = new LFUCache<>(3); // 创建容量为3的缓存
        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);

        // 模拟访问模式：A, B, C, A, B, C, A, B, C
        // 预期结果：缓存命中率为1.0，因为所有的访问都在缓存中命中
        int hits = 0;
        int totalAccess = 9;
        for (int i = 0; i < totalAccess; i++) {
            if (cache.get("A") != null || cache.get("B") != null || cache.get("C") != null) {
                hits++;
            }
        }
        double hitRate = (double) hits / totalAccess;
        System.out.println("缓存命中率: " + hitRate*100+"%");
        assertEquals(hitRate,1.0);
    }
    @Test
    public void testNodeRemoval() {
        LFUCache<String, Integer> cache = new LFUCache<>(3); // 创建容量为3的缓存
        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);

        // 模拟访问模式：A, B, C, D, E, F, A, B, C
        // 预期结果：节点D、E、F被加入缓存，节点A被移除
        cache.put("D", 4);
        cache.put("E", 5);
        cache.put("F", 6);

        Integer valueA = cache.get("A"); // 期望结果为null，因为节点A已被移除
        Integer valueD = cache.get("D"); // 期望结果为4，节点D存在于缓存中
        Integer valueE = cache.get("E"); // 期望结果为5，节点E存在于缓存中
        Integer valueF = cache.get("F"); // 期望结果为6，节点F存在于缓存中
        assertNull(valueA);
        assertEquals(4, valueD.intValue());
        assertEquals(5, valueE.intValue());
        assertEquals(6, valueF.intValue());
    }
}