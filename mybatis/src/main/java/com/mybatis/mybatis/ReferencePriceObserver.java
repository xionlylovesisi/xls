package com.mybatis.mybatis;

import org.springframework.stereotype.Component;

import java.util.Observable;
import java.util.Observer;

/**
 * 参考价通知
 * @author xls
 * @date 2018-12-09
 * @description
 */
@Component
public class ReferencePriceObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("ReferencePriceObserver hello world" + arg);
    }
}
