package com.mybatis.mybatis;

import com.mybatis.mybatis.service.ReferencePriceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {
    @Autowired
    private ReferencePriceService referencePriceService;
    @Autowired
    private ReferencePriceObservable referencePriceObservable;
    @Test
    public void save() {
        referencePriceService.save();
    }
    @Test
    public void testObserver(){
        referencePriceObservable.notifyObservers(null);
    }

}
