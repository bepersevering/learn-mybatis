package com.mingshashan.mybatis.learn.util;

import org.junit.Test;

/**
 * @author mingshashan
 */
public class IdGeneratorTest {

    @Test
    public void test_print() {
        String id1 = IdGenerator.generateId();
        String id2 = IdGenerator.generateId();
        String id3 = IdGenerator.generateId();
        String id4 = IdGenerator.generateId();
        System.out.println(id1);
        System.out.println(id2);
        System.out.println(id3);
        System.out.println(id4);
    }
}
