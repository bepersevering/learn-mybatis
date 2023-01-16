package com.mingshashan.mybatis.learn.util;

import org.junit.Test;

/**
 * @author mingshashan
 */
public class IdGeneratorTest {

    @Test
    public void test_print() {
        IdGenerator idGenerator = new IdGenerator();
        String id1 = idGenerator.nextStringId();
        String id2 = idGenerator.nextStringId();
        String id3 = idGenerator.nextStringId();
        String id4 = idGenerator.nextStringId();
        System.out.println(id1);
        System.out.println(id2);
        System.out.println(id3);
        System.out.println(id4);
    }
}
