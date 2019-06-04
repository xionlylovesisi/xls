package com.xlm.springel;

import com.xlm.springel.service.SpringElService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringElServiceTest {
    @Autowired
    private SpringElService springElService;
    @Test
    public void getElResultTest() {
        Object result = springElService.getElResult(1);
        System.out.println(result.toString());
    }

}
