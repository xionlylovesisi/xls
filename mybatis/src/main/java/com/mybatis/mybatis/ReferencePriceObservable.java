package com.mybatis.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 参考价通知上下文
 * @author xls
 * @date 2018-12-09
 * @description
 */
@Component
public class ReferencePriceObservable extends Observable {
    @Autowired
    public ReferencePriceObservable(List<Observer> observers){
        observers.forEach(observer -> {
            super.addObserver(observer);
        });
    }

    @Override
    public void notifyObservers(Object arg) {
        super.setChanged();
        super.notifyObservers(arg);
    }
}
