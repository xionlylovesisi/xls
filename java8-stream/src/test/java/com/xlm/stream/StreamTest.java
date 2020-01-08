package com.xlm.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamTest {

    @Test
    public void filterSexTest() {
        Stream.filterSex("男");
    }

    @Test
    public void filterSexAndAgeTest() {
        Stream.filterSexAndAge("男", 20);
    }

    @Test
    public void getUserNameListTest() {
        Stream.getUserNameList();
    }

    @Test
    public void flatMapStringTest() {
        Stream.flatMapString();
    }
    @Test
    public void reduceTest() {
        Stream.reduce();
    }
    @Test
    public void collectTest() {
        Stream.collect();
    }
    @Test
    public void optionalTest() {
        Stream.optional();
    }
    @Test
    public void parallelTest() {
        Stream.parallel();
    }
    @Test
    public void peekTest() {
        Stream.peek();
    }
}
