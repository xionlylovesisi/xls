package com.mybatis.mybatis.service;

import com.mybatis.mybatis.dao.ReferencePriceMapper;
import com.mybatis.mybatis.model.ReferencePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xls
 * @date 2018-12-08
 * @description
 */
@Service
public class ReferencePriceService {
    @Autowired
    private ReferencePriceMapper referencePriceMapper;
    public void save(){
        ReferencePrice referencePrice = new ReferencePrice();
        referencePrice.setId(123L);
        referencePriceMapper.insertSelective(referencePrice);
    }
}
