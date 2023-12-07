/*
 * This file was automatically generated by EvoSuite
 * Tue Dec 05 12:58:34 GMT 2023
 */

package com.bob;

import com.evosource.LFUCache_ESTest_scaffolding;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.evosuite.runtime.EvoAssertions.verifyException;
import static org.junit.Assert.*;

/**
 * 验证缓存的基本功能的正确性。包括存储（put）、获取（get）、移除操作。
 */
@RunWith(EvoRunner.class)
@EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true)
public class LFUCache_ESTest extends LFUCache_ESTest_scaffolding {

    @Test(timeout = 4000)
    public void test0() throws Throwable {
        Integer integer0 = new Integer(1317);
        Integer integer1 = Integer.getInteger("", 1);
        LFUCache<String, String> lFUCache0 = new LFUCache<String, String>(integer0);
        LFUCache<Object, LFUCache<String, String>> lFUCache1 = new LFUCache<Object, LFUCache<String, String>>(integer1);
        lFUCache1.put(integer1, lFUCache0);
        assertEquals(lFUCache1.get(integer1),lFUCache0);
        lFUCache1.put((Object) null, lFUCache0);
        assertEquals(lFUCache1.get(null),lFUCache0);
    }

    @Test(timeout = 4000)
    public void test1() throws Throwable {
        LFUCache<String, Object> lFUCache0 = new LFUCache<String, Object>();
        // Undeclared exception!
        try {
            lFUCache0.get("~P<S*#");
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            verifyException("com.bob.LFUCache", e);
        }
    }

    @Test(timeout = 4000)
    public void test2() throws Throwable {
        Integer integer0 = new Integer(75);
        LFUCache<Object, Integer> lFUCache0 = new LFUCache<Object, Integer>();
        LFUCache<Object, String> lFUCache1 = new LFUCache<Object, String>(integer0);
        LFUCache<Object, Object> lFUCache2 = new LFUCache<Object, Object>(integer0);
        lFUCache2.put(lFUCache0, (Object) null);
        assertNull(lFUCache2.get(lFUCache0));
        lFUCache2.put((Object) null, integer0);
        assertEquals(integer0,lFUCache2.get(null));
        lFUCache2.put(lFUCache0, lFUCache1);
        assertEquals(lFUCache1,lFUCache2.get(lFUCache0));
        Object object0 = new Object();
        lFUCache2.put(object0, integer0);
        assertEquals(integer0, lFUCache2.get(object0));
    }

    @Test(timeout = 4000)
    public void test3() throws Throwable {
        Integer integer0 = new Integer((-972));
        LFUCache<String, String> lFUCache0 = new LFUCache<String, String>(integer0);
        // Undeclared exception!
        try {
            lFUCache0.put((String) null, (String) null);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            verifyException("com.bob.LFUCache$Node", e);
        }
    }

    @Test(timeout = 4000)
    public void test4() throws Throwable {
        Integer integer0 = new Integer(75);
        LFUCache<Object, Integer> lFUCache0 = new LFUCache<Object, Integer>();
        LFUCache<Object, String> lFUCache1 = new LFUCache<Object, String>(integer0);
        LFUCache<Object, Object> lFUCache2 = new LFUCache<Object, Object>(integer0);
        lFUCache2.put(lFUCache0, (Object) null);
        assertNull(lFUCache2.get(lFUCache0));
        lFUCache2.put(lFUCache0, lFUCache1);
        assertEquals(lFUCache2.get(lFUCache0),lFUCache1);
        Object object0 = new Object();
        lFUCache2.put(object0, integer0);
        assertEquals(lFUCache2.get(object0),integer0);
    }

    @Test(timeout = 4000)
    public void test5() throws Throwable {
        Integer integer0 = new Integer(75);
        LFUCache<Object, String> lFUCache0 = new LFUCache<Object, String>(integer0);
        String string0 = lFUCache0.get(integer0);
        assertNull(string0);
    }

    @Test(timeout = 4000)
    public void test6() throws Throwable {
        Integer integer0 = new Integer(1982);
        LFUCache<String, String> lFUCache0 = new LFUCache<String, String>(integer0);
        lFUCache0.put("/,',`(x{.Mt_", "/,',`(x{.Mt_");
        String string0 = lFUCache0.get("/,',`(x{.Mt_");
        assertEquals("/,',`(x{.Mt_", string0);
    }

    @Test(timeout = 4000)
    public void test7() throws Throwable {
        Integer integer0 = new Integer(1287);
        LFUCache<String, String> lFUCache0 = new LFUCache<String, String>(integer0);
        lFUCache0.put("", "");
        assertEquals(lFUCache0.get(""),"");
        lFUCache0.put("com.bob.LFUCache$Node", "");
        assertEquals(lFUCache0.get("com.bob.LFUCache$Node"),"");
        lFUCache0.put("com.bob.LFUCache$Node", "com.bob.LFUCache$Node");
        assertEquals(lFUCache0.get("com.bob.LFUCache$Node"),"com.bob.LFUCache$Node");
    }
}
