package com.xlm.springel.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xls
 * @date 2019-05-09
 * @description mybatis config
 */
@Configuration
@MapperScan("com")
public class MybatisConfig {
}
